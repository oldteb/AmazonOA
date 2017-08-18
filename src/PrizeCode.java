package amazonOA;

import java.util.List;

public class PrizeCode {
	
	public int winPrize(List<String> shopList, List<List<String>> code) {
		return dfs(0,0,0,shopList, code);
	}
	
	int dfs(int cur, int outIdx, int inIdx, List<String> shopList, List<List<String>> code) {
		if(outIdx == code.size())  return 1;
		if(cur == shopList.size())  return 0;
		
		if(inIdx != 0) {
			if(match(shopList.get(cur), code.get(outIdx).get(inIdx))) {
				if(inIdx == code.get(outIdx).size()-1)  return dfs(cur+1, outIdx+1,0,shopList,code);
				else return dfs(cur+1,outIdx,inIdx+1,shopList,code);
			}
			else return 0;
		}
		else {
			for(int i = cur; i < shopList.size(); i++) {
				if(match(shopList.get(i), code.get(outIdx).get(inIdx))) {
					if(inIdx == code.get(outIdx).size()-1) {
						if(dfs(cur+1, outIdx+1,0,shopList,code) == 1)  return 1;
					}
					else {
						if(dfs(cur+1,outIdx,inIdx+1,shopList,code) == 1)  return 1;
					}
				}
				else continue;
			}
		}
		
		return 0;
	}
	
	boolean match(String str1, String str2) {
		if(str2.equals("anything"))  return true;
		else if(str2.equals(str1))  return true;
		else return false;
	}
	
}
