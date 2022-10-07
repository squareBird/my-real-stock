var express = require('express');
var router = express.Router();
var stockInfo = require('../StockInfoCrawling.js');


router.get('/:name', function (req, res) {
    for(let i = 1; i <= 38; i++) {
        stockInfo(req.params.name, i).then(function (result) {
            res.send(result);
        });
    }
});

module.exports = router;