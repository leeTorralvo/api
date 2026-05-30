let users = []

const tableBody = document.getElementById('userTableBody')
const userForm = document.getElementById('userForm')


/*
cargar los usuarios desde el backend y almacenarlos en la variable users
*/

const user = localStorage.getItem('user')

if(!user){

    window.location.href = '/login.html'
}

async function loadUsers() {

    try {

        const response = await fetch('http://localhost:8080/api/users')

        users = await response.json()

        renderUsers()

    } catch(error) {

        console.error('Error cargando usuarios:', error)
    }
}


/*
renderizar los datos en una tabla 
*/

function renderUsers() {

    tableBody.innerHTML = ''

    users.forEach(user => {

        let roleClass = ''

        if(user.role === 'ADMINISTRADOR') {
            roleClass = 'role-admin'
        }

        if(user.role === 'VENDEDOR') {
            roleClass = 'role-vendedor'
        }

        if(user.role === 'BODEGUERO') {
            roleClass = 'role-bodeguero'
        }

        tableBody.innerHTML += `

            <tr>

                <td>${user.nombre}</td>

                <td>${user.email}</td>

                <td>
                    <span class="badge-role ${roleClass}">
                        ${user.role}
                    </span>
                </td>

                <td>
                    <span class="badge bg-success">
                        Activo
                    </span>
                </td>

                <td>

                    <button class="btn btn-sm btn-outline-primary">
                        <i class="bi bi-pencil"></i>
                    </button>

                    <button 
                        class="btn btn-sm btn-outline-danger ms-2"
                        onclick="deleteUser(${user.id})"
                    >
                        <i class="bi bi-trash"></i>
                    </button>

                </td>

            </tr>
        `
    })
}


/*
registro de usuarios
*/

userForm.addEventListener('submit', async (e) => {

    e.preventDefault()

    const nombre = document.getElementById('nombre').value
    const email = document.getElementById('email').value
    const password = document.getElementById('password').value
    const role = document.getElementById('role').value

    const user = {
        nombre,
        email,
        password,
        role
    }

    try {

        await fetch('http://localhost:8080/api/users', {

            method: 'POST',

            headers: {
                'Content-Type': 'application/json'
            },

            body: JSON.stringify(user)
        })

        await loadUsers()

    } catch(error) {

        console.error('Error guardando usuario:', error)
    }

    userForm.reset()

    userForm.reset()

    document.getElementById('nombre').focus()

    alert('Usuario registrado correctamente')
})


/*
eliminar usuarios
*/

async function deleteUser(id) {

    const confirmDelete = confirm(
        '¿Deseas eliminar este usuario?'
    )

    if(!confirmDelete) return

    try {

        await fetch(`http://localhost:8080/api/users/${id}`, {

            method: 'DELETE'
        })

        await loadUsers()

    } catch(error) {

        console.error('Error eliminando usuario:', error)
    }
}

/*cerrar sesion*/
function logout() {

    localStorage.removeItem("user")

    window.location.href = "/login.html"
}



/*para iniciar la aplicacion*/

loadUsers()