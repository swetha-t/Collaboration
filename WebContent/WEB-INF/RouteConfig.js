var myapp = angular.module("myApp", ['ngRoute']);
app.config(function($routeProvider) {
    $routeProvider
      .when("#/",{templateUrl:"index.html"})
      .when("/Blog",{templateUrl:"Blog/Blog.html"})
    
});