var express = require('express');
var router = express.Router();
var detailStockInfo = require('../DetailStockInfoCrawling.js');
var simpleStockInfo = require('../SimpleStockInfoCrawling.js');
var checkValidateStockName = require('../CheckValidateStockName.js');
var searchStockInfo = require('../SearchStockInfoCrawling.js');


router.get('/detail/:name', function (req, res) {
    for(let i = 1, j = 0; i <= 38; i++, j++) {
        setTimeout(() => {
            detailStockInfo(req.params.name, i).then(function (result) {
                res.send(result);
            });
        }, j * 50)
    }
});

router.get('/simple/:name', function (req, res) {
    for(let i = 1, j = 0; i <= 38; i++, j++) {
        setTimeout(() => {
            simpleStockInfo(req.params.name, i).then(function (result) {
                res.send(result);
            }).catch(function (err) {
                res.send(err);
            });
        }, j * 50)
    }
});

router.get('/check/:name', function (req, res) {
    for(let i = 1, j = 0; i <= 38; i++, j++) {
        setTimeout(() => {
            checkValidateStockName(req.params.name, i).then(function (result) {
                res.send(result);
            }).catch(function (err) {
                res.send(err);
            });
        }, j * 50)
    }
});


router.get('/search/:name', function (req, res) {
    setTimeout(() => {
        searchStockInfo(req.params.name, 1).then(function (result) {
            res.send(result);
        }).catch(function (err) {
                res.send(err);
        });
    }, 100)

});

module.exports = router;