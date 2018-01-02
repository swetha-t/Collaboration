var app=angular.module("myApp",['ngRoute','ngCookies']);

app.config(function($routeProvider, $locationProvider) {
	$locationProvider.hashPrefix('');
    $routeProvider
    
      .when("#/",{templateUrl:"index.html"})
      
      .when("#/",{templateUrl:"home.html", 
    	  controller:"mainController"
    		  })
      
      
      .when("/Blog",{
    	  templateUrl:"Blog/Blog.html",
    	  controller:"BlogController"
    		  })
      
       .when("/Forum",{
    	   templateUrl:"Forum/forum.html",
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
         
    .when("/login",{
    	templateUrl:"user/login.html",
    	controller:"userController"
    		
    })
    
    
     .when("/registration",{
    	 
    	 templateUrl:"user/registration.html",
    	 controller:"userController"
     
     	})
     	.when('/Chat', {
     		templateUrl : 'Chat/chat.html',
     		controller : "chatController"
     			})
     	
     	
     });

app.run(function($rootScope,$cookieStore){
	console.log('i am in run function');
	console.log($rootScope.currentUser);
	if($rootScope.currentUser==undefined)
		{
		$rootScope.currentUser=$cookieStore.get('user');
		}
	else{
		console.log($rootScope.currentUser.username);
		console.log($rootScope.currentUser.role);
	}
});

app.controller("mainController", function($scope) {
	$scope.message = "This is home page";
});
