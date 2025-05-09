package tmg.za.CapIndex.shared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import tmg.za.CapIndex.client.data.GetAdminUser;
import tmg.za.CapIndex.client.data.GetBank;
import tmg.za.CapIndex.client.data.GetCapIndex;
import tmg.za.CapIndex.client.data.GetCountry;
import tmg.za.CapIndex.client.data.GetRewardHistory;
import tmg.za.CapIndex.client.data.GetState;
import tmg.za.CapIndex.client.data.GetUser;

/**
 * 
 */
public class MySQLConnection extends RemoteServiceServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
	private String url = "jdbc:mysql://localhost:3306/mysql";
	private String user = "root";
	private String pass = "Letmein@home";

	public MySQLConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			// NEVER catch exceptions like this
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @param userName
	 * @param pass
	 * @return
	 */
	public GetAdminUser authenticateUser(String userName, String pass) {
		GetAdminUser user = null;
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from CAP_ADMIN where admin_username = ? and admin_password = ?");
			ps.setString(1, userName);
			String hash = StringUtils.getMd5(pass);
			ps.setString(2, hash);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				user = new GetAdminUser(result.getString(2), result.getString(3));
			}
			result.close();
			ps.close();
		} catch (SQLException sqle) {
			// do stuff on fail
		}
		return user;
	}

	/**
	 * @return
	 */
	public ArrayList<GetCountry> getCountries() {
		ArrayList<GetCountry> result = new ArrayList<GetCountry>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from CAP_COUNTRY");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GetCountry country = new GetCountry();
				country.setId(rs.getInt(1));
				country.setCountryName(rs.getString(2));
				country.setCountryCode(rs.getString(3));
				result.add(country);

			}
			rs.close();
			ps.close();
		} catch (SQLException sqle) {
			// do stuff on fail
		}

		return result;
	}

	/**
	 * @return
	 */
	public ArrayList<GetState> getStates() {
		ArrayList<GetState> result = new ArrayList<GetState>();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"select State_ID,State_name,State_code,Country_ID,Country_name from cap_state,cap_country where cap_state.State_country_id = cap_country.Country_id");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GetState state = new GetState();
				state.setId(rs.getInt(1));
				state.setStateName(rs.getString(2));
				state.setStateCode(rs.getString(3));
				state.setStateCountryId(rs.getInt(4));
				state.setCountyName(rs.getString(5));
				result.add(state);

			}
			rs.close();
			ps.close();
		} catch (SQLException sqle) {
			// do stuff on fail
		}

		return result;
	}

	/**
	 * @return
	 */
	public ArrayList<GetAdminUser> getAdminUsers() {
		ArrayList<GetAdminUser> result = new ArrayList<GetAdminUser>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from CAP_ADMIN");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GetAdminUser admin = new GetAdminUser();
				admin.setUsername(rs.getString(2));
				// admin.setLast_login(StringUtils.nget(rs.getTimestamp(3)));
				// admin.setCreated_date(StringUtils.nget(rs.getTimestamp(4)));
				result.add(admin);

			}
			rs.close();
			ps.close();
		} catch (SQLException sqle) {
			// do stuff on fail
		}

		return result;
	}

	/**
	 * @return
	 */
	public ArrayList<GetUser> getUsers() {
		ArrayList<GetUser> result = new ArrayList<GetUser>();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"select  USER_FIRST_NAME,USER_LAST_NAME,USER_CARD_NUMBER,USER_BANK_ID,USER_LOYALTY_CREDIT,BANK_NAME from CAP_USER,CAP_BANK where CAP_USER.USER_BANK_ID = CAP_BANK.Bank_ID");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GetUser user = new GetUser();
				user.setFirstName(rs.getString(1));
				user.setLastName(rs.getString(2));
				user.setCardNumber(rs.getString(3));
				user.setBankID(rs.getString(4));
				user.setLoyaltyCredit(rs.getDouble(5));
				user.setBankName(rs.getString(6));
				result.add(user);

			}
			rs.close();
			ps.close();
		} catch (SQLException sqle) {
			// do stuff on fail
		}

		return result;
	}

	/**
	 * @return
	 */
	public ArrayList<GetBank> getBanks() {
		ArrayList<GetBank> result = new ArrayList<GetBank>();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"select BANK_ID,BANK_NAME,BANK_HQ,BANK_STATE_ID,STATE_NAME,BANK_ABA_ROUTING,BANK_SWIFT_CODE from cap_bank,cap_state where BANK_STATE_ID=STATE_ID");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GetBank bank = new GetBank();
				bank.setId(rs.getInt(1));
				bank.setBankName(rs.getString(2));
				bank.setBankHq(rs.getString(3));
				bank.setBankStateId(rs.getInt(4));
				bank.setBankStateName(rs.getString(5));
				bank.setAbaRouting(rs.getString(6));
				bank.setBankSwiftCode(rs.getString(7));
				result.add(bank);

			}
			rs.close();
			ps.close();
		} catch (SQLException sqle) {
			// do stuff on fail
		}

		return result;
	}

	/**
	 * @return
	 */
	public ArrayList<GetRewardHistory> getRewardHistory() {
		ArrayList<GetRewardHistory> result = new ArrayList<GetRewardHistory>();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"select REWARD_ID,REWARD_DESCRIPTION,REWARD_TRANSACTION_TIME,REWARD_USER_ID,USER_CARD_NUMBER,REWARD_AMOUNT,REWARD_FINAL_AMOUNT,REWARD_APPLIED,REWARD_TOKEN_INDEX FROM CAP_REWARD_HISTORY,CAP_USER where REWARD_USER_ID=USER_ID");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GetRewardHistory rewardHistory = new GetRewardHistory();
				rewardHistory.setId(rs.getInt(1));
				rewardHistory.setRewardDescription(rs.getString(2));
				rewardHistory.setRewardTransactionTime(rs.getDate(3));
				rewardHistory.setRewardUserId(rs.getInt(4));
				rewardHistory.setUserCardNumber(rs.getString(5));
				rewardHistory.setRewardAmount(rs.getDouble(6));
				rewardHistory.setFinalAmount(rs.getDouble(7));
				rewardHistory.setRewardApplied(rs.getBoolean(8));
				rewardHistory.setTokenIndex(rs.getInt(9));
				result.add(rewardHistory);

			}
			rs.close();
			ps.close();

		} catch (SQLException sqle) {
			// do stuff on fail
		}

		return result;
	}

	/**
	 * @return
	 */
	public ArrayList<GetCapIndex> getCapIndex() {
		ArrayList<GetCapIndex> result = new ArrayList<GetCapIndex>();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"select INDEX_ID,INDEX_CITY_NAME,INDEX_STATE_ID,STATE_NAME,INDEX_PRICE_USD,INDEX_PRICE_ZAR,INDEX_UNIT_FIRST_CHARGE,INDEX_SURCHARGE_PERCENTAGE,INDEX_SURCHARGE_LIMIT,INDEX_SURCHARGE_PRICE,INDEX_UNIT_LAST_PRICE,INDEX_SURCHARGE_FINAL,INDEX_TOURISM_TOKEN,INDEX_BANK_ID,BANK_NAME from cap_index,cap_state,cap_bank where index_state_id=STATE_ID AND index_bank_id = BANK_ID");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GetCapIndex index = new GetCapIndex();
				index.setId(rs.getInt(1));
				index.setCityName(rs.getString(2));
				index.setStateId(rs.getInt(3));
				index.setStateName(rs.getString(4));
				index.setPriceUsd(String.valueOf(rs.getDouble(5)));
				index.setPriceZar(String.valueOf(rs.getDouble(6)));
				index.setUnitFirstCharge(String.valueOf(rs.getDouble(7)));
				index.setSurchargePercentage(String.valueOf(rs.getDouble(8)));
				index.setSurchargeLimit(String.valueOf(rs.getDouble(9)));
				index.setSurchargePrice(String.valueOf(rs.getDouble(10)));
				index.setUnitLastPrice(String.valueOf(rs.getDouble(11)));
				index.setSurchargeFinal(String.valueOf(rs.getDouble(12)));
				index.setTourismToken(rs.getString(13));
				index.setBankId(rs.getInt(14));
				index.setBankName(rs.getString(15));

				result.add(index);

			}
			rs.close();
			ps.close();
		} catch (SQLException sqle) {
			// do stuff on fail
		}

		return result;
	}

	/**
	 * @param updates
	 * @return
	 */
	public ArrayList<GetCapIndex> setCapIndex(ArrayList<GetCapIndex> updates) {
		try {
			PreparedStatement ps = conn.prepareStatement(
					"update CAP_INDEX set INDEX_CITY_NAME = ?,INDEX_PRICE_USD = ?,INDEX_PRICE_ZAR = ?,INDEX_UNIT_FIRST_CHARGE = ?,INDEX_SURCHARGE_PERCENTAGE = ?,INDEX_SURCHARGE_LIMIT = ?,INDEX_SURCHARGE_PRICE = ?,INDEX_UNIT_LAST_PRICE = ?,INDEX_SURCHARGE_FINAL = ?,INDEX_TOURISM_TOKEN = ? where INDEX_ID = ?");
			for (GetCapIndex value : updates) {
				ps.setString(1, value.getCityName());
				ps.setDouble(2, Double.valueOf(value.getPriceUsd()));
				ps.setDouble(3, Double.valueOf(value.getPriceZar()));
				ps.setDouble(4, Double.valueOf(value.getUnitFirstCharge()));
				ps.setDouble(5, Double.valueOf(value.getSurchargePercentage()));
				ps.setDouble(6, Double.valueOf(value.getSurchargeLimit()));
				ps.setDouble(7, Double.valueOf(value.getSurchargePrice()));
				ps.setDouble(8, Double.valueOf(value.getUnitLastPrice()));
				ps.setDouble(9, Double.valueOf(value.getSurchargeFinal()));
				ps.setString(10, value.getTourismToken());
				ps.setInt(11, value.getId());
				ps.execute();
			}

			ps.close();
		} catch (SQLException sqle) {
			// do stuff on fail
		}

		return getCapIndex();
	}

}
