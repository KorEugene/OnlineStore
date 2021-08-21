angular.module('market-front', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market/';

    $scope.firstPageIndex = 1;
    $scope.lastPageIndex = 1;
    $scope.currentPage = 1;

    $scope.changePage = function (offset) {
        let nextPageIndex = $scope.currentPage + offset;
        if (nextPageIndex < $scope.firstPageIndex || nextPageIndex > $scope.lastPageIndex) {
            $scope.loadProducts($scope.currentPage)
        } else {
            $scope.currentPage = nextPageIndex;
            $scope.loadProducts($scope.currentPage)
        }
    }

    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + 'api/v1/products',
            method: 'GET',
            params: {
                p: pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.lastPageIndex = response.data.totalPages;
            $scope.productsPage = response.data;
        });
    };

    $scope.delete = function (product) {
        $http({
            url: contextPath + 'api/v1/products/delete',
            method: 'GET',
            params: {
                p: product.id
            }
        }).then(function (response) {
            console.log(response);
            $scope.loadProducts();
        });
    };

    $scope.loadProducts();

});
