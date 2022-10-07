var express = require('express');
var router = express.Router();
var stockInfo = require('../StockInfoCrawling.js');


router.get('/:name', function (req, res) {
    for(let i = 1, j = 0; i <= 38; i++, j++) {
        setTimeout(() => {
            stockInfo(req.params.name, i).then(function (result) {
                res.send(result);
            });
        }, j * 50)
    }
});

module.exports = router;