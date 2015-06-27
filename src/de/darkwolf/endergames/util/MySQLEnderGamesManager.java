package de.darkwolf.endergames.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.bukkit.entity.Player;

public class MySQLEnderGamesManager {
	
	private static ExecutorService executor;
	
	static {
		executor = Executors.newCachedThreadPool();
	}
	
	/**
	 * check is the player in the database
	 * @param p
	 * @return returnStatement
	 */
	public static boolean isPlayerInDatabase(Player p) {
		boolean returnStatement = false;
		String qry = "SELECT * FROM " + MySQL.TABLE_ENDERGAMES + " WHERE uuid = ?";
		try {
			PreparedStatement pstmt = MySQL.con.prepareStatement(qry);
			pstmt.setString(1, p.getUniqueId().toString());
			ResultSet rs = pstmt.executeQuery();
			if(rs.first()) returnStatement = true;
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnStatement;
	}
	
	/**
	 * add a new player to the database
	 * @param p
	 */
	public static void addNewPlayer(Player p) {
		executor.execute(new Runnable() {
			@Override
			public void run() {
				String qry = "INSERT INTO " + MySQL.TABLE_ENDERGAMES + " (uuid, playername, kits, kills, deaths, points, wins, played) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				try {
					PreparedStatement pstmt = MySQL.con.prepareStatement(qry);
					pstmt.setString(1, p.getUniqueId().toString());
					pstmt.setString(2, p.getName());
					pstmt.setString(3, "");
					pstmt.setInt(4, 0);
					pstmt.setInt(5, 0);		
					pstmt.setInt(6, 0);
					pstmt.setInt(7, 0);
					pstmt.setInt(8, 0);
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * edit the playername from a player of the database
	 * @param uuid
	 */
	public static void setPlayername(Player p, String playername) {
		if(isPlayerInDatabase(p)) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					String qry = "UPDATE " + MySQL.TABLE_ENDERGAMES + " SET playername = ? WHERE uuid = ?";
					try {
						PreparedStatement pstmt = MySQL.con.prepareStatement(qry);
						pstmt.setString(1, playername);
						pstmt.setString(2, p.getUniqueId().toString());
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	/**
	 * get the kills from a player of the database
	 * @param p
	 * @return returnsatement
	 */
	public static Integer getPlayerKills(Player p) {
		int returnsatement = 0;
		String qry = "SELECT * FROM " + MySQL.TABLE_ENDERGAMES + " WHERE uuid = ?";
		if(isPlayerInDatabase(p)) {
			try {
				PreparedStatement pstmt = MySQL.con.prepareStatement(qry);
				pstmt.setString(1, p.getUniqueId().toString());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					returnsatement = rs.getInt("kills");
				}
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnsatement;	
	}
	
	/**
	 * get the deaths from a player of the database
	 * @param p
	 * @return returnsatement
	 */
	public static Integer getPlayerDeaths(Player p) {
		int returnsatement = 0;
		String qry = "SELECT * FROM " + MySQL.TABLE_ENDERGAMES + " WHERE uuid = ?";
		if(isPlayerInDatabase(p)) {
			try {
				PreparedStatement pstmt = MySQL.con.prepareStatement(qry);
				pstmt.setString(1, p.getUniqueId().toString());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					returnsatement = rs.getInt("deaths");
				}
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnsatement;	
	}
	
	/**
	 * get the points from a player of the database
	 * @param p
	 * @return returnsatement
	 */
	public static Integer getPlayerPoints(Player p) {
		int returnsatement = 0;
		String qry = "SELECT * FROM " + MySQL.TABLE_ENDERGAMES + " WHERE uuid = ?";
		if(isPlayerInDatabase(p)) {
			try {
				PreparedStatement pstmt = MySQL.con.prepareStatement(qry);
				pstmt.setString(1, p.getUniqueId().toString());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					returnsatement = rs.getInt("points");
				}
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnsatement;	
	}
	
	/**
	 * get the wins from a player of the database
	 * @param p
	 * @return returnsatement
	 */
	public static Integer getPlayerWins(Player p) {
		int returnsatement = 0;
		String qry = "SELECT * FROM " + MySQL.TABLE_ENDERGAMES + " WHERE uuid = ?";
		if(isPlayerInDatabase(p)) {
			try {
				PreparedStatement pstmt = MySQL.con.prepareStatement(qry);
				pstmt.setString(1, p.getUniqueId().toString());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					returnsatement = rs.getInt("wins");
				}
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnsatement;	
	}
	
	/**
	 * get the played games from a player of the database
	 * @param p
	 * @return returnsatement
	 */
	public static Integer getPlayerPlayedGames(Player p) {
		int returnsatement = 0;
		String qry = "SELECT * FROM " + MySQL.TABLE_ENDERGAMES + " WHERE uuid = ?";
		if(isPlayerInDatabase(p)) {
			try {
				PreparedStatement pstmt = MySQL.con.prepareStatement(qry);
				pstmt.setString(1, p.getUniqueId().toString());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					returnsatement = rs.getInt("played");
				}
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnsatement;	
	}
	
	/**
	 * add a player of the database a kill
	 * @param uuid
	 */
	public static void addPlayerKill(Player p) {
		if(isPlayerInDatabase(p)) {
			int kills = getPlayerKills(p) + 1;
			executor.execute(new Runnable() {
				@Override
				public void run() {
					String qry = "UPDATE " + MySQL.TABLE_ENDERGAMES + " SET kills = ? WHERE uuid = ?";
					try {
						PreparedStatement pstmt = MySQL.con.prepareStatement(qry);
						pstmt.setInt(1, kills);
						pstmt.setString(2, p.getUniqueId().toString());
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	/**
	 * add a player of the database a death
	 * @param uuid
	 */
	public static void addPlayerDeath(Player p) {
		if(isPlayerInDatabase(p)) {
			int deaths = getPlayerDeaths(p) + 1;
			executor.execute(new Runnable() {
				@Override
				public void run() {
					String qry = "UPDATE " + MySQL.TABLE_ENDERGAMES + " SET deaths = ? WHERE uuid = ?";
					try {
						PreparedStatement pstmt = MySQL.con.prepareStatement(qry);
						pstmt.setInt(1, deaths);
						pstmt.setString(2, p.getUniqueId().toString());
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	/**
	 * add a player of the database a point
	 * @param uuid
	 */
	public static void addPlayerPoint(Player p) {
		if(isPlayerInDatabase(p)) {
			int points = getPlayerPoints(p) + 1;
			executor.execute(new Runnable() {
				@Override
				public void run() {
					String qry = "UPDATE " + MySQL.TABLE_ENDERGAMES + " SET points = ? WHERE uuid = ?";
					try {
						PreparedStatement pstmt = MySQL.con.prepareStatement(qry);
						pstmt.setInt(1, points);
						pstmt.setString(2, p.getUniqueId().toString());
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	/**
	 * add a player of the database a point
	 * @param uuid
	 */
	public static void removePlayerPoint(Player p) {
		if(isPlayerInDatabase(p)) {
			int points = getPlayerPoints(p) - 1;
			executor.execute(new Runnable() {
				@Override
				public void run() {
					String qry = "UPDATE " + MySQL.TABLE_ENDERGAMES + " SET points = ? WHERE uuid = ?";
					try {
						PreparedStatement pstmt = MySQL.con.prepareStatement(qry);
						pstmt.setInt(1, points);
						pstmt.setString(2, p.getUniqueId().toString());
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	/**
	 * add a player of the database a win
	 * @param uuid
	 */
	public static void addPlayerWin(Player p) {
		if(isPlayerInDatabase(p)) {
			int wins = getPlayerWins(p) + 1;
			executor.execute(new Runnable() {
				@Override
				public void run() {
					String qry = "UPDATE " + MySQL.TABLE_ENDERGAMES + " SET wins = ? WHERE uuid = ?";
					try {
						PreparedStatement pstmt = MySQL.con.prepareStatement(qry);
						pstmt.setInt(1, wins);
						pstmt.setString(2, p.getUniqueId().toString());
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	/**
	 * add a player of the database a played game
	 * @param uuid
	 */
	public static void addPlayerPlayedGame(Player p) {
		if(isPlayerInDatabase(p)) {
			int played = getPlayerPlayedGames(p) + 1;
			executor.execute(new Runnable() {
				@Override
				public void run() {
					String qry = "UPDATE " + MySQL.TABLE_ENDERGAMES + " SET played = ? WHERE uuid = ?";
					try {
						PreparedStatement pstmt = MySQL.con.prepareStatement(qry);
						pstmt.setInt(1, played);
						pstmt.setString(2, p.getUniqueId().toString());
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
}
