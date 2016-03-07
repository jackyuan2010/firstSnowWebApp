var app = app || {};

(function(){

	// --------- Remote Das --------- //
	app.groupDao = brite.registerDao(new app.GroupDaoHandler("Group"));
    app.contactDao = brite.registerDao(new app.ContactDaoHandler("Contact"));
	// --------- /Remote Das --------- //

})();