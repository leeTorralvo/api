document
.getElementById('loginForm')
.addEventListener('submit', function(e){

    e.preventDefault()

    const email =
        document.getElementById('email').value

    localStorage.setItem(
        'user',
        email
    )

    window.location.href = '/'
})