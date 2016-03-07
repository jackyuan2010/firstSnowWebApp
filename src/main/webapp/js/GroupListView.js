(function(){

	brite.registerView("GroupListView", {
		create: function(){
			return app.groupDao.getGroups({orderBy:"groupName"}).pipe(function(result){
			    return render("GroupListView", {groups:result});
			});
		},

        postDisplay: function(){
            var view = this;
            view.$addNewGroup = view.$el.find(".add-new-group");
            selectCurrentGroup.call(this);
        },

        events: {

            "click; .add-new-group a": function(event){
                var view = this;
                view.$addNewGroup.addClass("active");
                view.$addNewGroup.find("input").focus();
            },

            "keyup; .add-new-group input":function(event){
                var view = this;
                var $input = view.$addNewGroup.find("input");
                var key = event.which;
                var newGroup;
                if(key === 13){
                    var userId = app.user.userId;
                    newGroup = {
                        groupName: $input.val(),
                        userId: userId
                    };
                    $input.val("");
                    app.groupDao.createGroup(newGroup).done(function(groupCreated){
                        view.$addNewGroup.removeClass("active");
                        $input.val("");
                    });
                }
                else if(key === 27){
                    view.$addNewGroup.removeClass("active");
                    $input.val("");
                }
            },
        },

	    daoEvents: {
            "dataChange; Group": refreshlist
	    },

		docEvents: {
			"APP_CTX_CHANGE": function(event){
				selectCurrentGroup.call(this);
			}
		},
	});

    function refreshlist(){
        var view = this;
        app.groupDao.getGroups({orderBy:"groupName"}).done(function(result){
            var html = render("GroupListView-list",{groups:result});
            view.$el.find("ul").bEmpty().html(html);
        });
    }

	function selectCurrentGroup(){
		var view = this;
		var groupId = (app.ctx.pathAt(0) === "group")?app.ctx.pathAsNum(1):null;
		if (groupId !== null){
			view.$el.find("li[data-entity='Group'].active").removeClass("active");
			var $li = view.$el.find("li[data-entity='Group'][data-entity-id='" + groupId + "']");
			$li.addClass("active");
		}
	}
})();
