import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Apriori {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/store_db";

	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {

		// no of itemsets
		int n = 0;
		// no of items
		int items = 15;
		ArrayList<ArrayList<Integer>> itemset = new ArrayList<ArrayList<Integer>>();

		Connection conn = null;
		Statement stmt = null;

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			System.out.println("Statement object initialized...");
			String sql;
			sql = "SELECT items_purchased, t_id from register";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				n++;
				String transactions = rs.getString(1);
				int tid = rs.getInt(2);

				String str[];
				str = transactions.split(" ");
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for (int j = 0; j < str.length; j++) {
					temp.add(Integer.parseInt(str[j]));
				}
				itemset.add(temp);

				// Display values
				System.out.println("transactions : " + transactions + " tid : "
						+ tid);
			}

			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the minimum threshold : ");
			int th = 2;// sc.nextInt();

			ArrayList<LinkedHashSet<Integer>> list = new ArrayList<LinkedHashSet<Integer>>();
			ArrayList<Integer> listCount = new ArrayList<Integer>();

			// for counting support count of individual items
			int count = 0;
			for (int i = 0; i < items; i++) {
				LinkedHashSet<Integer> l = new LinkedHashSet<Integer>();
				l.add(i + 1);
				list.add(l);
				for (int j = 0; j < n; j++) {
					ArrayList<Integer> t = itemset.get(j);
					for (int k = 0; k < t.size(); k++) {
						if (t.get(k) == (i + 1)) {
							count++;
							break;
						}
					}
				}
				listCount.add(count);
				count = 0;
			}

			ArrayList<LinkedHashSet<Integer>> answer = new ArrayList<LinkedHashSet<Integer>>();
			ArrayList<Integer> ansListCount = new ArrayList<Integer>();
			// iterating till the support count > minimum threshold
			// int iter = 1;
			while (!list.isEmpty()) {

				// printing part
				// if (list.size() != 0)
				// System.out.println("\nBefore " + iter
				// + " iteration : \nItemset:\t\tSupport Count:");
				// for (int i = 0; i < list.size(); i++) {
				// System.out.println(Arrays.toString(list.get(i).toArray())
				// + "\t\t\t" + listCount.get(i));
				// }

				// removing itemsets with less support count than minimum
				int size = list.size();
				int inc = 0;
				for (int i = 0; i < size - inc; i++) {
					if (listCount.get(i) < th) {
						list.remove(i);
						listCount.remove(i);
						i--;
						inc++;
					}
				}

				if (list.size() != 0) {
					answer = new ArrayList<LinkedHashSet<Integer>>(list);
					ansListCount = new ArrayList<Integer>(listCount);
				}

				ArrayList<LinkedHashSet<Integer>> finallist = new ArrayList<LinkedHashSet<Integer>>();

				LinkedHashSet<Integer> tempList = new LinkedHashSet<Integer>();
				LinkedHashSet<LinkedHashSet<Integer>> newList = new LinkedHashSet<LinkedHashSet<Integer>>();

				// combining itemsets
				for (int i = 0; i < list.size() - 1; i++) {
					for (int j = i + 1; j < list.size(); j++) {
						Iterator<Integer> iterator = list.get(i).iterator();
						while (iterator.hasNext()) {
							tempList.add(iterator.next());
						}
						iterator = list.get(j).iterator();
						while (iterator.hasNext()) {
							tempList.add(iterator.next());
						}

						int newListSize = newList.size();
						newList.add(tempList);
						if (newListSize != newList.size()) {
							finallist.add(tempList);
						}
						tempList = new LinkedHashSet<Integer>();
					}
				}

				// transferring from new list to the old one
				list.clear();
				list = new ArrayList<LinkedHashSet<Integer>>(finallist);

				// updating listCount(support count) of the newlist
				listCount.clear();
				int count2 = 0, c = 0;
				for (int i = 0; i < list.size(); i++) {
					for (int j = 0; j < n; j++) {

						Iterator<Integer> iterator = list.get(i).iterator();
						while (iterator.hasNext()) {
							int x = iterator.next();

							ArrayList<Integer> t = itemset.get(j);

							int m;
							for (m = 0; m < t.size(); m++) {
								if (t.get(m) == x) {
									break;
								}
							}
							if (m != t.size()) {
								c++;
							}
						}
						if (c == list.get(i).size()) {
							count2++;
						}
						c = 0;
					}
					listCount.add(count2);
					count2 = 0;
				}

				// printing part
				// if (list.size() != 0)
				// System.out.println("\nAfter " + iter
				// + " iteration : \nItemset:\t\tSupport Count:");
				// iter++;
				// for (int i = 0; i < list.size(); i++) {
				// System.out.println(Arrays.toString(list.get(i).toArray())
				// + "\t\t\t" + listCount.get(i));
				// }

			}

			// clear table related items
			PreparedStatement pstmt = conn
					.prepareStatement("delete from related_items where 1");
			pstmt.executeUpdate();
			
			if (answer.size() == 0) {
				System.out.println("Answer is empty! :/");
			} else {
				System.out.println("Final list :\nItemset:\t\tSupport Count:");
				for (int i = 0; i < answer.size(); i++) {
					System.out.println(Arrays.toString(answer.get(i).toArray())
							+ "\t\t\t" + ansListCount.get(i));
				}

				
				for (int i = 0; i < answer.size(); i++) {
					Object arr[] = answer.get(i).toArray();
					int a[] = new int[arr.length];
					for (int j = 0; j < arr.length; j++) {
						a[j] = (int) arr[j];
					}
					String itemsets = "";
					for (int j = 0; j < a.length; j++) {
						itemsets += a[j] + " ";
					}
					itemsets = itemsets.trim();

					// insert itemset in the database table

					pstmt = conn
							.prepareStatement("insert into related_items values(?,?)");
					pstmt.setInt(1, i + 1);// 1 specifies the first parameter in
											// the
											// query
					pstmt.setString(2, itemsets);

					pstmt.executeUpdate();

				}
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
			sc.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try

	}
}
