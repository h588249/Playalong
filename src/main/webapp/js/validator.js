function isUsernameValid(username)
{
    let regex = /^[a-zæøåA-ZÆØÅ0-9 _.-]{4,20}$/;

    if (username.match(regex))
        return true;
    return false;
}

function isEmailValid(email)
{
    let regex = /^[a-zæøåA-ZÆØÅ0-9._%+-]+@[a-zæøåA-ZÆØÅ0-9.-]+[.][a-zA-Z]{2,6}$/;

    if (email.match(regex) && email.length >= 6 && email.length <= 40)
        return true;
    return false;
}

function isPasswordValid(password)
{
    let regex = /^(?=.*[0-9])(?=.*[!@#$%^&*._-])[a-zA-Z0-9!@#$%^&*._-]{8,20}$/;
    
    if (password.match(regex))
        return true;
    return false;
}