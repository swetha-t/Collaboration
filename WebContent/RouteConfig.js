var app=angular.module("myApp",['ngRoute','ngCookies']);

app.config(function($routeProvider, $locationProvider) {
	$locationProvider.hashPrefix('');
    $routeProvider
    
      .when("#/",{templateUrl:"index.html"})
      
      .when("/home",{
    	  templateUrl:"home.html", 
    	  
    		  })
      
      
      .when("/postblog",{
    	  templateUrl:"Blog/Blog.html",
    	  controller:"BlogController"
    		  })
    		  
      .when("/viewblog",{
    	  templateUrl:"Blog/ViewBlog.html",
    	  controller:"BlogController"
    		  })
    		  
      
       .when("/forum",{
    	   templateUrl:"forum/forum.html",
    		   controller:"forumController"  
       })
       
        .when("/adminBlog",{
        	templateUrl:"Blog/adminBlog.html",
        	controller:"adminBlogController"
        })
        
         .when("/jobs",{
        	 templateUrl:"jobs/jobs.html",
        	 controller:"jobsController"
        		 })
        		 
         .when("/showjobs",{
        	 templateUrl:"jobs/Showjobs.html",
        	 controller:"jobsController"
        		 })		 
         
         
    .when("/login",{
    	templateUrl:"user/login.html",
    	controller:"UserController"
    		
    })
    
     .when("/Friend",{
    	 templateUrl:"user/Friend.html",
    	 controller:"userController"
     })
    
     .when("/registration",{
    	 
    	 templateUrl:"user/registration.html",
    	 controller:"userController"
     
     	})
     	
     	 .when("/FriendRequest",{
     		 templateUrl:"Friend/ShowFriendRequest.html",
     		 controller:"FriendController"
     	 })
     	.when('/Chat', {
     		templateUrl : 'Chat/Chat.html',
     		controller : "ChatController"
     			})
     	
     	
     });

app.run(function($rootScope,$cookieStore){
	console.log('i am in run function');
	console.log($rootScope.currentUser);
	if($rootScope.currentUser==undefined)
		{
		$rootScope.currentUser=$cookieStore.get('userDetails');
		}
	else{
		console.log($rootScope.currentUser.username);
		console.log($rootScope.currentUser.role);
	}
});


app.controller("mainController", function($scope) {
	$scope.message = "This is home page";
});
