(function(){
    brite.registerView("ContactView", {
		create: function(groupId){
			return app.contactDao.getContactsByGroupId(groupId).pipe(function(result){
			    return render("ContactView", {contacts:result});
			});
		},

		postDisplay: function(){
		    var view = this;
		    var groupId = (app.ctx.pathAt(0) === "group")?app.ctx.pathAsNum(1):null;
			view.groupId = groupId;
		},

        events: {
            "click; .contactTable tr":function(event){
                var view = this;
                var target = event.currentTarget;
                view.$el.find("tr.active").removeClass("active");
                $(target).addClass("active");
            },

            "click; .del-ico":function(event){
                var view = this;
                var currentRow = view.$el.find("tr.active");
                var contactId = parseInt($(currentRow).attr("data-entity-id"));
                if(contactId == 0 || contactId == NaN){
                    currentRow.find("input").each(function(index, element){
                        $(element).val("");
                    });
                }
            },

            "click; .save-ico":function(event){
                var view = this;
                var currentRow = view.$el.find("tr.active");
                var contactId = parseInt($(currentRow).attr("data-entity-id"));
                var contactName,phoneNO,officePhone,familyPhone,contactAdd;
                currentRow.find("input").each(function(index, element){
                    var attrValue = $(element).attr("data-prop");
                    switch(attrValue){
                        case "contactName":
                            contactName = $(element).val();
                        break;
                        case "phoneNO":
                            phoneNO = $(element).val();
                        break;
                        case "officePhone":
                            officePhone = $(element).val();
                        break;
                        case "familyPhone":
                            familyPhone = $(element).val();
                        break;
                        case "contactAdd":
                            contactAdd = $(element).val();
                        break;
                    }
                });
                if(contactId == 0 || contactId == NaN){
                    var newContact;
                    newContact = {
                        contactName: contactName,
                        phoneNO: phoneNO,
                        officePhone: officePhone,
                        familyPhone: familyPhone,
                        contactAdd: contactAdd,
                        groupId: view.groupId
                    };
                    app.contactDao.createContact(newContact).done(function(){
                        refreshtable.call(this);
                    });
                }
                else{
                }
            },
        },

	    daoEvents: {
            "dataChange; Contact": refreshtable
	    },
    });

    function refreshtable(){
        var view = this;
        this.$el.trigger("DO_REFRESHCONTACTS");
    }
})();