//todo check if thymeleaf may be used here to fetch from server
const emailRegex = /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/g;
const phoneNumberRegex = /^(\+38)?\d{10}$/g;
const hasLettersRegex = /[a-zA-Z]/g;
const passwordRegex = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?!.* ).{6,16}$/g;

function isEmailValid(email) {
	return emailRegex.test(email);
}

function isPhoneNumberValid(number) {
	return phoneNumberRegex.test(number);
}

function isPasswordValid(password) {
	return passwordRegex.test(password);
}

function isPhoneNumber(data) {
	return !data.match(hasLettersRegex);
}

function validateUserLogin(login) {
	var emailValid = isEmailValid(login);
	var phoneNumberValid = isPhoneNumberValid(login);
	return {
		isValid: emailValid || phoneNumberValid,
		isEmail: emailValid || !isPhoneNumber(login),
		isPhone: phoneNumberValid || isPhoneNumber(login),
	};
}

function validationClass(fieldValue, isValid) {
		if (fieldValue.length < 1) {
			return "";
		}
    	return isValid ? "is-valid" : "is-invalid";
}