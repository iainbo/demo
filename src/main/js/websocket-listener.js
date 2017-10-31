'use strict';

const SockJs = require('sockjs-client');
require('stompjs');

function register(registrations){
    var socket = SockJs('/demo');
    var stompClient = Stomp.over(socket);

    stompClient.connect({}, function(frame){
        registrations.forEach(function (registrtion) {
            stompClient.subscribe(registrtion.route, registrtion.callback)
        });
    });
}

module.exports.register = register;