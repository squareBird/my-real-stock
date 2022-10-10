var express = require('express');
var router = express.Router();
var detailStockInfo = require('../DetailStockInfoCrawling.js');
var simpleStockInfo = require('../SimpleStockInfoCrawling.js')


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
            });
        }, j * 50)
    }
});

module.exports = router;