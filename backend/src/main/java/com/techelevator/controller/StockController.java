package com.techelevator.controller;

import com.techelevator.dao.TradeDao;
import com.techelevator.model.StockResponse;
import com.techelevator.model.Trade;
import com.techelevator.model.TradeRequest;
import com.techelevator.model.TradeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class StockController {

    private TradeDao tradeDao;

    public StockController(TradeDao tradeDao) {
        this.tradeDao = tradeDao;
    }

    @RequestMapping(value = "/games/{gameId}/stocks", method = RequestMethod.GET)
    public List<StockResponse> getStockList(@PathVariable int gameId){
        return tradeDao.getStocksByGameId(gameId);
    }

    @RequestMapping(value = "/games/{gameId}/trades", method = RequestMethod.GET)
    public List<TradeResponse> getTradeList(@PathVariable int gameId){
        return tradeDao.getTradesByGameId(gameId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/games/trades", method = RequestMethod.POST)
    public void tradeStocks(@RequestBody TradeRequest trade, Principal principal){
        tradeDao.tradeStocks(trade, principal);
    }


}
