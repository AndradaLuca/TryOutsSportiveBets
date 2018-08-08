package com.example.marius.sportivebets.utils;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.home.MenuItem;
import com.example.marius.sportivebets.home.MenuItemsModel;
import com.example.marius.sportivebets.home.sport_fragments.football.Game;
import com.example.marius.sportivebets.home.sport_fragments.football.LeagueTitle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Constants {

    private static final MenuItem footballItem = new MenuItem("Football", R.drawable.soccer);
    private static final MenuItem tenisItem = new MenuItem("Tenis", R.drawable.tennisball);
    private static final MenuItem pingPongItem = new MenuItem("PingPong", R.drawable.pingpong);
    private static final MenuItem basketBallItem = new MenuItem("Basketball", R.drawable.basketball);
    private static final MenuItem cricketItem = new MenuItem("Cricket", R.drawable.cricket);
    private static final MenuItem badmintonItem = new MenuItem("Badminton", R.drawable.badminton);
    private static final MenuItem rugbyItem = new MenuItem("Rugby", R.drawable.americanfootball);
    private static final MenuItem bowlingItem = new MenuItem("Bowling", R.drawable.bowling);
    private static final MenuItem chessItem = new MenuItem("Chess", R.drawable.chess);
    private static final MenuItem golfItem = new MenuItem("Golf", R.drawable.golf);
    private static final MenuItem hockeyItem = new MenuItem("Hockey", R.drawable.hockey);
    private static final MenuItem boxItem = new MenuItem("Box", R.drawable.boxing);
    private static final MenuItem volleyballItem = new MenuItem("Volleyball", R.drawable.volleyball);


    public static final List<MenuItemsModel> menuItems = Arrays.asList(new MenuItemsModel(footballItem),
            new MenuItemsModel(tenisItem), new MenuItemsModel(pingPongItem), new MenuItemsModel(basketBallItem),
            new MenuItemsModel(cricketItem), new MenuItemsModel(badmintonItem), new MenuItemsModel(rugbyItem),
            new MenuItemsModel(bowlingItem), new MenuItemsModel(chessItem), new MenuItemsModel(golfItem),
            new MenuItemsModel(hockeyItem), new MenuItemsModel(boxItem), new MenuItemsModel(volleyballItem));

    private static Game game1 = new Game("Botosani", "Astra Giurgiu", 2.40, 3.15, 3.15);
    private static Game game2 = new Game("Concordia", "Hermannstadt", 2.00, 4.15, 3.25);
    private static Game game3 = new Game("Sepsi", "CSMS Iasi", 2.05, 4.00, 3.25);
    private static Game game4 = new Game("Dunarea Calarasi", "Universitatea Craiova", 3.85, 2.05, 3.35);
    private static Game game5 = new Game("FC Voluntari", "CFR Ecomax", 4.40, 1.90, 3.35);


    private static Game game6 = new Game("CS Balotesti", "Petrolu Ploiesti", 5.45, 1.54, 3.75);
    private static Game game7 = new Game("Academia Clinceni", "Daco-Getica", 2.35, 2.60, 3.35);
    private static Game game8 = new Game("Sportul Snagov", "CS Mioveni", 2.25, 2.80, 3.25);
    private static Game game9 = new Game("Luceafarul", "Ripensia", 2.45, 2.55, 3.25);
    private static Game game10 = new Game("Metaloglobus", "Aerostar Bucuresti", 2.55, 2.45, 3.25);

    private static Game game11 = new Game("Man Utd", "Leicester", 1.50, 7.50, 4.15);
    private static Game game12 = new Game("NewCastle", "Tottenham", 3.75, 2.05, 3.45);
    private static Game game13 = new Game("Huddersfield", "Chelsea", 5.95, 1.62, 3.85);
    private static Game game14 = new Game("Watford", "Brighton", 2.30, 3.35, 3.25);
    private static Game game15 = new Game("Fulham", "Crystal Palace", 2.35, 3.10, 3.35);

    private static Game game16 = new Game("Barcelona", "Sevilla", 1.55, 5.85, 4.25);

    private static Game game17 = new Game("Real Madrid", "Atletico Madrid", 2.45, 2.95, 3.25);

    private static Game game18 = new Game("Eintracht", "Bayer Munchen", 6.65, 1.42, 4.76);

    private static Game game19 = new Game("Chelsea", "Lyon", 2.15, 3.45, 3.55);
    private static Game game20 = new Game("Real Madrid", "AS Roma", 1.76, 4.15, 4.15);
    private static Game game21 = new Game("Atletico Madrid", "Inter Milan", 2.15, 3.45, 3.56);

    private static Game game22 = new Game("Marseille", "Toulouse", 1.41, 7.75, 4.45);
    private static Game game23 = new Game("Nantes", "Monaco", 3.23, 2.34, 3.25);
    private static Game game24 = new Game("Angers", "Nimes", 2.31, 3.25, 3.27);
    private static Game game25 = new Game("Lille", "Stade Rennes", 2.55, 2.95, 3.15);

    private static Game game26 = new Game("FK Qarabag", "BATE Borisov", 7.25, 1.54, 3.55);
    private static Game game27 = new Game("Malmo", "MOL Vidi", 2.25, 5.15, 2.45);
    private static Game game28 = new Game("Slavia Prague", "Dynamo Kiev", 2.45, 3.45, 2.75);
    private static Game game29 = new Game("Red Star", "Spartak", 1.23, 15.7, 5.45);


    private static List<Game> league1 = Arrays.asList(game1, game2, game3, game4, game5);
    private static List<Game> league2 = Arrays.asList(game6, game7, game8, game9, game10);
    private static List<Game> league3 = Arrays.asList(game11, game12, game13, game14, game15);
    private static List<Game> league4 = Collections.singletonList(game16);
    private static List<Game> league5 = Collections.singletonList(game17);
    private static List<Game> league6 = Collections.singletonList(game18);
    private static List<Game> league7 = Arrays.asList(game19, game20, game21);
    private static List<Game> league8 = Arrays.asList(game22, game23, game24, game25);
    private static List<Game> league9 = Arrays.asList(game26, game27, game28, game29);

    public static List<LeagueTitle> leagueTitles = Arrays.asList(new LeagueTitle("Romania - Liga 1", league1),
            new LeagueTitle("Romania - Liga 2", league2), new LeagueTitle("Anglia - Premier League", league3),
            new LeagueTitle("Spain Super Cup", league4), new LeagueTitle("UEFA Super Cup", league5),
            new LeagueTitle("Germany Super Cup", league6), new LeagueTitle("International Champions Cup", league7),
            new LeagueTitle("France - Ligue 1", league8), new LeagueTitle("Champions League Qualifying", league9));


}
