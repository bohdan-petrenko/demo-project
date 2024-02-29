function LoginModel() {
	var self = this;
	this.isValidated = ko.observable(true);
	this.userLogin = ko.observable("");
	this.isUserLoginValid = ko.pureComputed(function() {
		return validateUserLogin(self.userLogin());
	}, self);
	this.userLoginValidationClass = ko.pureComputed(function() {
		return validationClass(self.userLogin(), self.isUserLoginValid().isValid)
    }, self);
	this.userPassword = ko.observable("");
	this.isUserPasswordValid = ko.pureComputed(function() {
		return isPasswordValid(self.userPassword());
	}, self);
	this.userPasswordValidationClass = ko.pureComputed(function() {
		return validationClass(self.userPassword(), self.isUserPasswordValid())
	}, self);
	this.doSignIn = function() {
		alert(this.userLogin() + " => " + this.userPassword());
	}
};
ko.applyBindings(new LoginModel());