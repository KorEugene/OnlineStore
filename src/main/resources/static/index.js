angular.module('market-front', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market/';

    $scope.firstPageIndex = 1;
    $scope.lastPageIndex = 1;
    $scope.currentPage = 1;

    // $scope.loadProducts = function () {
    //     $http.get(contextPath + 'products')
    //         .then(function (response) {
    //             console.log(response);
    //             $scope.productsPage = response.data;
    //         });
    // };

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
            url: contextPath + 'products',
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
            url: contextPath + 'delete',
            method: 'GET',
            params: {
                p: product.id
            }
        }).then(function (response) {
            console.log(response);
            $scope.loadProducts();
        });
    };

    // $scope.wrongRequest = function () {
    // WRONG:
    // $http.get(contextPath + 'products/update/1');
    // reload();

    // CORRECT
    // $http.get(contextPath + 'products/update/1')
    //     .then(function (response) {
    //         reload();
    //     });
    // }

    $scope.loadProducts();

});
