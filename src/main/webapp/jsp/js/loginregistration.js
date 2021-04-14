const registerButton = document.getElementById('register');
const loginButton = document.getElementById('login');
const container = document.getElementById('container');

const loginEmail = document.getElementById('login_email');
const loginPassword = document.getElementById('login_password');

const registerUsername = document.getElementById('register_username')
const registerEmail = document.getElementById('register_email')
const registerPassword = document.getElementById('register_password')
const registerPasswordRepeat = document.getElementById('register_passwordRep')



registerButton.addEventListener('click', () => {
    container.classList.add("right-panel-active");
});

loginButton.addEventListener('click', () => {
    container.classList.remove("right-panel-active");
});

function validateRegisterAll()
{
    if (!isUsernameValid(document.register.username.value) ||
        !isEmailValid(document.register.email.value) ||
        !isPasswordValid(document.register.password.value) ||
        document.register.password.value !== document.register.passwordRep.value)
    {

        alert("Registration must be completed correctly");
        return false;
    }
}

function validateLoginAll()
{
    if (!isEmailValid(document.register.email.value) ||
        !isPasswordValid(document.register.password.value))
    {
        alert("Login using correct credidentials");
        return false;
    }
}

function validateRegisterUsername()
{
    checkCorrect(isUsernameValid(document.register.username.value), registerUsername);
}

function validateLoginEmail()
{
    checkCorrect(isEmailValid(document.login.email.value), loginEmail);
}

function validateRegisterEmail()
{
    checkCorrect(isEmailValid(document.register.email.value), registerEmail);
}

function validateLoginPassword()
{
    checkCorrect(isPasswordValid(document.login.password.value), loginPassword);
}

function validateRegisterPassword()
{
    let password = document.register.password.value;
    let passrep = document.register.passwordRep.value;

    checkCorrect(isPasswordValid(password), registerPassword);
    checkCorrect(password === passrep, registerPasswordRepeat);
}

function checkCorrect(check, element)
{
    if (check)
        correct(element);
    else
        incorrect(element);
}

function correct(element)
{
    element.classList.add("correct");
    element.classList.remove("incorrect");
}

function incorrect(element)
{
    element.classList.add("incorrect");
    element.classList.remove("correct");
}
