import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {

    getGames(token, status) {
        return http.get(`/games/${status}`,{headers: {'Authorization': `Bearer ${token}`}});
    },
    createGame(game,token){
        console.log(token);
        return http.post('/games',
        game,{headers: {'Authorization': `Bearer ${token}`}});
    },
    gameInvite(id,invite,token){
        return http.post(`/games/${id}/invite`, invite,
        {headers: {'Authorization': `Bearer ${token}`}});
    }
}