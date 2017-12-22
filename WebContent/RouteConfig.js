
var myapp=angular.module("myApp",['ngRoute']);
myapp.config(function($routeProvider) {
    $routeProvider
      .when("#/",{templateUrl:"index.html"})
      .when("#/",{templateUrl:"home.html", controller:"mainController"})
      
      .when("/Blog",{templateUrl:"Blog/Blog.html"})
      
       .when("/Forum",{templateUrl:"Forum/forum.html"})
       
        .when("/adminBlog",{templateUrl:"Blog/adminBlog.html"})
        
         .when("/jobs",{templateUrl:"jobs/jobs.html"})
         
    .when("/login",{
    	
    
    	templateUrl:"User/login.html",
    	controller:'userController'
    		
    })
    
    
     .when("/registration",{
    	 
    	 templateUrl:"User/registration.html",
    	 controller:'userController'
     
     	})
      .when("/friend",{templateUrl:"friend/friend.html"})

});


/*app.controller("mainController", function($scope) {
	$scope.message = "This is home page";
});*/