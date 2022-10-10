let request = require('request');
let cheerio = require('cheerio');
const iconv = require('iconv-lite');
let Promise = require('promise');


const findStock = function(stockName, no)  {
    let j = request.jar();
    let cookie = request.cookie(`field_list=12|04E00000`);
    let url = `https://finance.naver.com`;
    j.setCookie(cookie, url);

    return new Promise((resolve, reject) => {
        request({
            url: `https://finance.naver.com/sise/sise_market_sum.nhn?&page=${no}`,
            jar: j,
            encoding: null
        }, function (error, response, body) {
            const decodedBody = iconv.decode(body, 'euc-kr');
            const $ = cheerio.load(decodedBody);

            for(let i = 0; i < $("tbody a.tltle").length; i++) {
                if(($("tbody a.tltle")[i].children[0].data) == stockName){

                    let j = i * 8;
                    let stockInfo = {
                        stockName: $("tbody a.tltle")[i].children[0].data,
                        nowPrice: $("tbody td.number")[j++].children[0].data,
                    };
                    resolve(stockInfo);
                }
            }
        });
    });
}

const getStockInfo = function(stockName, no) {
    return new Promise((resolve, reject) => {
        request(`https://finance.naver.com/sise/sise_market_sum.nhn?&page=${no}`, function (error, response, body) {
            const $ = cheerio.load(body);
            var stockInfo = findStock(stockName, no)
            resolve(stockInfo);
        });
    });
}

module.exports = getStockInfo;