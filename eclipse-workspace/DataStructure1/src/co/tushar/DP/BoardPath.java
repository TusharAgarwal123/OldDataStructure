package co.tushar.DP;

public class BoardPath {

	public static void main(String[] args) {

		System.out.println(boardPath_Memo(1, 9, new int[10]));
		System.out.println(boardPath_dp(1, 9, new int[10]));
		
	}

	public static int boardPath_Memo(int sp, int ep, int[] dp) {

		if (sp == ep) {
			return dp[sp]=1;
		}

		if(dp[sp]!=0) {
			return dp[sp];
		}
		
		int c = 0;
		for (int dice = 1; dice <= 6; dice++) {

			if (dice + sp <= ep) {
				c += boardPath_Memo(sp + dice, ep, dp);
			}

		}
		return dp[sp]=c;

	}
	
	public static int boardPath_dp(int sp, int ep, int[] dp) {

		int nmu=sp;
		
		for(sp=ep;sp>=0;sp--) {
			
			if (sp == ep) {
				 dp[sp]=1;
				 continue;
			}

			
			
			int c = 0;
			for (int dice = 1; dice <= 6; dice++) {

				if (dice + sp <= ep) {
					c += dp[sp+dice];
				}

			}
			dp[sp]=c;
			
		}
		
		return dp[nmu];
		
		

	}
	
	

}
