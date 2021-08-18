angular.module('market-front', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market/';

    $scope.firstPage = 1;
    $scope.currentPage = $scope.firstPage;
    $scope.lastPage = 1;

    // $scope.loadProducts = function () {
    //     $http.get(contextPath + 'products')
    //         .then(function (response) {
    //             console.log(response);
    //             $scope.productsPage = response.data;
    //         });
    // };

    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + 'products',
            method: 'GET',
            params: {
                p: pageIndex
            }
        }).then(function (response) {
            console.log(response);
            // if (pageIndex >= 1 || pageIndex <= response.data.totalPages) {
            $scope.currentPage = pageIndex;
            // }
            // console.log(response.data.first)
            // console.log(response.data.last)
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
