'use strict';

angular.module('drivaidApp')
    .controller('AddressController', function ($scope, $state, $modal, Address) {
      
        $scope.addresss = [];
        $scope.loadAll = function() {
            Address.query(function(result) {
               $scope.addresss = result;
            });
        };
        $scope.loadAll();


        $scope.refresh = function () {
            $scope.loadAll();
            $scope.clear();
        };

        $scope.clear = function () {
            $scope.address = {
                number: null,
                longitude: null,
                latitude: null,
                name: null,
                description: null,
                id: null
            };
        };
    });
