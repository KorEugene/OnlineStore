angular.module('market-front', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market/';

    let currentPageIndex = 1;
    // $scope.firstPageIndex = 1;
    // $scope.lastPageIndex = 1;
    // $scope.currentPage = 1;

    // $scope.changePage = function (offset) {
    //     let nextPageIndex = $scope.currentPage + offset;
    //     if (nextPageIndex < $scope.firstPageIndex || nextPageIndex > $scope.lastPageIndex) {
    //         $scope.loadProducts($scope.currentPage)
    //     } else {
    //         $scope.currentPage = nextPageIndex;
    //         $scope.loadProducts($scope.currentPage)
    //     }
    // }

    $scope.loadProducts = function (pageIndex = 1) {
        currentPageIndex = pageIndex;
        $http({
            url: contextPath + 'api/v1/products',
            method: 'GET',
            params: {
                p: pageIndex
            }
        }).then(function (response) {
            console.log(response);
            // $scope.lastPageIndex = response.data.totalPages;
            $scope.productsPage = response.data;
            $scope.paginationArray = $scope.generatePagesIndexes(1, $scope.productsPage.totalPages);
        });
    };

    $scope.createNewProduct = function () {
        $http.post(contextPath + 'api/v1/products', $scope.new_product)
            .then(function successCallback(response) {
                $scope.loadProducts(currentPageIndex);
                $scope.new_product = null;
            }, function failureCallback(response) {
                alert(response.data.message);
            });
    }

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.deleteProduct = function (product) {
        $http({
            url: contextPath + 'api/v1/products',
            method: 'DELETE',
            params: {
                p: product.id
            }
        }).then(function (response) {
            console.log(response);
            $scope.loadProducts(currentPageIndex);
        });
    };

    $scope.updateProduct = function () {
        $http.put(contextPath + 'api/v1/products', $scope.update_product)
            .then(function successCallback(response) {
                $scope.loadProducts(currentPageIndex);
                $scope.update_product = null;
            }, function failureCallback(response) {
                alert(response.data.message);
            });
    }

    $scope.loadProducts();

});
