myapp.controller("adminBlogController", function($scope, $http, $location) {
	function fetchAllBlog() {
		console.log("Fetching all blogs");
		$http.get("http://localhost:8181/Collabaration/getAllBlogs")

		.then(function(response) {
			$scope.blogdata = response.data;
			console.log("Blog fetched");
		});
	}
	;
	fetchAllBlog();
	$scope.approveBlog=function(blogId) 
	{
		console.log("entered in approve blog");
		$http.get('http://localhost:8181/Collabaration/approveBlog/'+ blogId)
				.then(fetchAllBlog(), function(response) 
		{
			console.log("Blog is approved");
		}
		)
	}
	$scope.rejectBlog=function(blogId)
	{
	$http.get('http://localhost:8181/Collabaration/rejectBlog/'+blogId)
	.then(fetchAllBlog(),function(response){
		console.log('blog rejected');
	})
	}
});