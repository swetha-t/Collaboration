	
	
app.controller("BlogController",function($scope,$http,$location,$rootScope)
		
		{
		$scope.blog={blogId:" ",blogName:" ",blogContent:" ",createDate:"",likes:0,username:"",status:"NA"}
		$scope.blog;

		function fetchAllBlog()
		{
		console.log('Fetching all blogs');
		$http.get("http://localhost:8181/Collabaration/getAllBlogs")
		.then(function(response)
		{
			$scope.blogdata=response.data;
		});

		
		}
	
		
		
		var BASE_URL='http://localhost:8181/Collabaration'
		  	$scope.insertBlog=function()
		  	{
		  		console.log('Entered into InsertBlog');
		 		$http.post(BASE_URL+"/insertBlog", $scope.blog).then(function(response)
		  				{
		  				console.log('Successful Blog Entered');
		  				});
		  	}
		
		
		
		

	var BASE_URL="http://localhost:8181/Collabaration"
		$scope.updateBlog=function()
		{
			console.log('Entered into UpdateBlog');
			$http.post(BASE_URL+"/updateBlog", $scope.blog).then(function(response)
					{
					console.log('Successful Blog updated');
					});
		}
	
	
	var BASE_URL="http://localhost:8181/Collabaration"
		$scope.deleteBlog=function()
		{
			console.log('Entered into DeleteBlog');
			$http.post(BASE_URL+"/deleteBlog", $scope.blog).then(function(response)
					{
					console.log('Successful Blog deleted');
					});
		}
	
	$scope.likeBlog=function(blogId)
	{
		console.log("enterd into like ");
		$http.get('http://localhost:8181/Collabaration/incLike/'+ blogId)
		.success(fetchAllBlog(),function(response)
				{
				console.log("like incremented")
				$scope.refresh();
				$location.path("/blog");
				});
};
});


