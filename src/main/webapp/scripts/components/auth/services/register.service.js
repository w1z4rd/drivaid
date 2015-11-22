'use strict';

angular.module('drivaidApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


