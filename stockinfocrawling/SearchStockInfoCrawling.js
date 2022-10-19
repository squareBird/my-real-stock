let request = require('request');
let cheerio = require('cheerio');
const iconv = require('iconv-lite');
let Promise = require('promise');


let stockInfo = {}
var stockInfoList = new Array();

const findStock = function(encodeStockName, no)  {

    return new Promise((resolve, reject) => {
        request({
            url: `https://finance.naver.com/search/searchList.naver?query=${encodeStockName}&page=${no}`,
            encoding: null
        }, function (error, response, body) {
            const decodedBody = iconv.decode(body, 'euc-kr');
            const $ = cheerio.load(decodedBody);
            // console.log($(".paging a").length);
            // console.log($(".section_search tbody td")[17].children[0].data);
            // console.log($(".section_search tbody td.tit").length);

            for(let i = 0, j = 1; i < $(".section_search tbody td.tit").length; i++, j++) {
                stockInfo = {
                    stockName: $(".section_search tbody td.tit a")[i].children[0].data,
                    nowPrice: $(".section_search tbody td")[j].children[0].data,
                    price1: $(".section_search tbody td.num2 img")[i].next.data.replace(/(\s*)/g, ""),
                    price2: $(".section_search tbody td.num3")[i].children[0].data,
                    price3: $(".section_search tbody td")[j+=3].children[0].data,
                    price4: $(".section_search tbody td")[++j].children[0].data,
                    price5: $(".section_search tbody td")[++j].children[0].data,
                    price6: $(".section_search tbody td")[++j].children[0].data

                };
                // const s = JSON.stringify(stockInfo);
                // stockInfoList.push(s);
                stockInfoList.push(stockInfo);

            }

            // setTimeout(() => {
            //     resolve(stockInfoList);
            // }, 500);
            resolve(stockInfoList);

        });

    });
}

const getStockInfo = function(stockName, no) {
    const encodeStockName = iconv.encode(stockName, 'euc-kr');
    return new Promise((resolve, reject) => {
        request(`https://finance.naver.com/search/searchList.naver?query=%BB%EF%BC%BA&page=${no}`, function (error, response, body) {
            const $ = cheerio.load(body);
            // for(let i = 1, j = 0; i <= $(".paging a").length; i++, j++) {
            // }
                var s = findStock("%BB%EF%BC%BA", no);
                resolve(s);
        });
    });
}


// getStockInfo("%BB%EF%BC%BA").then(function (result) {
//     console.log(result.length);
//     console.log(result);
//
// });



// for(let i = 1, j = 0; i <= 5; i++, j++) {
//     setTimeout(() => {
//         getStockInfo("삼성전자").then(function (result) {
//             console.log(result);
//         });
//     }, j * 1000)
// }

module.exports = getStockInfo;



















































// let request = require('request');
// let cheerio = require('cheerio');
// const iconv = require('iconv-lite');
// let Promise = require('promise');
//
//
// let stockInfo = {}
// var stockInfoList = new Array();
//
// const findStock = function(stockName, no)  {
//     let j = request.jar();
//     let cookie = request.cookie(`field_list=12|04E00000`);
//     let url = `https://finance.naver.com`;
//     j.setCookie(cookie, url);
//
//     return new Promise((resolve, reject) => {
//         request({
//             url: `https://finance.naver.com/sise/sise_market_sum.nhn?&page=${no}`,
//             jar: j,
//             encoding: null
//         }, function (error, response, body) {
//             const decodedBody = iconv.decode(body, 'euc-kr');
//             const encode = iconv.encode(stockName, 'euc-kr');
//             const $ = cheerio.load(decodedBody);
//
//             for(let i = 0, k = 0; i < $("tbody a.tltle").length; i++) {
//                 if(($("tbody a.tltle")[i].children[0].data).includes(stockName)){
//
//                     let j = i * 8;
//                     stockInfo = {
//                         name: $("tbody a.tltle")[i].children[0].data,
//                         nowPrice: $("tbody td.number")[j++].children[0].data,
//                         compareNum: $("tbody td.number span.tah")[k++].children[0].data.replace(/(\s*)/g, ""),
//                         percentage: $("tbody td.number span.tah")[k++].children[0].data.replace(/(\s*)/g, ""),
//                         price1: $("tbody td.number")[j+=2].children[0].data,
//                         price2: $("tbody td.number")[++j].children[0].data,
//                         price3: $("tbody td.number")[++j].children[0].data,
//                         price4: $("tbody td.number")[++j].children[0].data,
//                         price5: $("tbody td.number")[++j].children[0].data
//                     };
//
//                     const s = JSON.stringify(stockInfo);
//                     resolve(s);
//                 }
//                 k += 2;
//             }
//         });
//     });
// }
//
// const getStockInfo = function(stockName, no) {
//     return new Promise((resolve, reject) => {
//         request(`https://finance.naver.com/sise/sise_market_sum.nhn?&page=${no}`, function (error, response, body) {
//             const $ = cheerio.load(body);
//             var s = findStock(stockName, no)
//             resolve(s);
//         });
//     });
// }
//
// for(let i = 1, j = 0; i <= 38; i++, j++) {
//     setTimeout(() => {
//         getStockInfo("삼성전자", i).then(function (result) {
//             console.log(result);
//         });
//     }, j * 1000)
//
//
// }
//
// module.exports = getStockInfo;