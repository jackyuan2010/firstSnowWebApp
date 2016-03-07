<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>My First Snow And Brite WebApp - Login Page</title>

	<link rel="stylesheet" href="${_r.contextPath}/bootstrap/css/bootstrap.min.css" type="text/css" />

    [@webBundle path="/common/js/" type="js" /]
	<style>
	html,body{
		height: 100%;
	}
	#authpage{
		position: absolute;
		top: 40%;
		left: 50%;
		margin-left: -240px;
		margin-top: -150px;
		width: 480px;
		border: solid 1px #ddd;
	}
	.panel-heading{
		position: relative;
	}
	.panel-heading > span{
		letter-spacing: .1em;
	}
	.form-group{
		margin-top: 10px;
		margin-bottom: 20px;
	}
	.show-for-register{
		display: none;
	}
	#loginswitch{
		position: absolute;
		top: 5px;
		right: 10px;
	}
	.panel-footer > small{
		float: right;
	}
	.error-style{
		color:red;
	}
	</style>

	<script type="text/javascript">
	$(function(){
		var SIGNIN = "SIGNIN", REGISTER = "REGISTER";
		var labels = {
			SIGNIN: "Sign In",
			REGISTER: "Register"
		};
		var submitRooting = {
			SIGNIN: {
				path: "/login",
				data: function(){
					return {
						username: $("#input-username").val(),
						password: $("#input-pwd").val()
					};
				}
			},
			REGISTER: {
				path: "/register",
				data: function(){
					return {
						username: $("#input-username").val(),
						password: $("#input-pwd").val(),
						pwdRepeat: $("#input-pwd-repeat").val(),
					};
				}
			}
		};

		var $submit = $("#submit-button");

		// --------- Mode Switch (Signin/Register) --------- //
		// Handle the signin/register switch
		$("#loginswitch").on("click",".btn",function(){
			var $btn = $(this);
			var val = $btn.attr("name");
			$btn.parent().find(".btn").removeClass("btn-success").addClass("btn-default");
			$btn.removeClass("btn-default").addClass("btn-success");
			$btn.blur(); // make sure it is blur, we do not want the focus
			if (REGISTER === val){
				$(".show-for-register").show();
			}else{
				$(".show-for-register").hide();
			}
			$("input[name='username']").focus();
			$(".login-label").html(labels[val]);
			$("button[type='submit']").attr("name",val);
		});

		$submit.on("click",submit);
		$(document).on("keyup",function(event){
			if (event.which === 13){
				submit();
			}
		});

		function submit(){
			var type = $submit.attr("name");
			var rooting = submitRooting[type];
			$.ajax(rooting.path,{
				type: "POST",
				data: rooting.data(),
				dataType: "json"
			}).done(function(response){
				if (response.success){
					window.location.reload(true);
				}else{
					var $msg = $("<span/>").html(response.errorMessage).appendTo($("#error-msg"));
					setTimeout(function(){
						$msg.fadeOut();
					},4000);
				}
			});
		}
	});
	</script>
</head>

<body>

	<div id="authpage" class="panel panel-primary">
		<div class="panel-heading"><span class="login-label">Signin</span>
			<div id="loginswitch" class="btn-group">
			  <button name="SIGNIN"   type="button" class="btn btn-success btn-sm">Sign In</button>
			  <button name="REGISTER" type="button" class="btn btn-default btn-sm">Register</button>
			</div>
		</div>

		<div class="panel-body">
			<div class="form">
				<div class="form-group">
					<input id="input-username" name="username" type="text" class="form-control dx"  autofocus placeholder="username">
				</div>
				<div class="form-group">
					<input id="input-pwd" name="pwd" type="password" class="form-control dx" placeholder="password">
				</div>
				<div class="show-for-register form-group">
					<input id="input-pwd-repeat" name="repeat" type="password" class="form-control dx" placeholder="repeat password">
				</div>
				<button id="submit-button" type="submit" name="SIGNIN" class="btn btn-primary login-label">Sign In</button>
			</div>
		</div> <!-- /.panel-body -->

		<div class="panel-footer"><span id="error-msg" class="error-style">&nbsp;</span> <small><a href="#">Forgot password</a></small></div>
	</div>

</body>

</html>