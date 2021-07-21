import java.lang.Math.*;
import java.math.RoundingMode;
import java.math.BigDecimal;

public class SME{
	float ev;

	public static void main(String[] args){
		/*
		boolean meths[] = new boolean[4];
		for(int i=3;i<7;i++){
			if(args[i].equals("1")){
				meths[i-3]=true;
			}
			else{
				meths[i-3]=false;
			}
		}
		int dp = Integer.parseInt(args[2]);*/
		SME sm4 = new SME("alal","all",16,new boolean[]{false, true, false, false});
		SME sm3 = new SME("ha","ha",new boolean[]{false, false, false, true});
		SME sm2 = new SME("ha","ha",5);
		SME sm1 = new SME("ha","ha");
		System.out.println(sm4.ev);
		System.out.println(sm3.ev);
		System.out.println(sm2.ev);
		System.out.println(sm1.ev);
	}

	public SME(String a, String b, int dp, boolean[] meths){
		ev = eval(a,b,dp,meths);
	}
	public SME(String a, String b, boolean[] meths){
		ev = eval(a,b,2,meths);
	}
	public SME(String a, String b, int dp){
		ev = eval(a,b,dp,new boolean[]{true, true, true, true});
	}
	public SME(String a, String b){
		ev =  eval(a,b,2,new boolean[]{true, true, true, true});
	}


	public float eval(String a, String b, int dp, boolean[] meths){
		if(a.equals(b)){
			return 1f;
		}
		else{
			float aggregate=0f;
			int methcount=0;
			for(int i=0; i<4; i++){
				if(meths[i]){
					methcount++;
					switch(i){
						case 0: //cha
							aggregate+=charmatch(a,b);
							break;
						case 1: //len
							aggregate+=lenmatch(a.length(),b.length());
							break;
						case 2: //pat
							aggregate+=patmatch();
							break;
						case 3: //trad
							aggregate+=tradmatch(a,b);
							break;
					}
				}
			}
			if(methcount!=0){
				aggregate/=methcount;
			}
			BigDecimal bd = new BigDecimal(aggregate).setScale(dp, RoundingMode.FLOOR);
			aggregate = bd.floatValue();
			return aggregate;
		}
	}

	public static float lenmatch(int a, int b){
		double aa = a;
		double bb = b;
		//return((float)Math.pow(aa/(Math.max(bb,((2*aa)-bb))),1.2));
		//return((float)Math.pow(aa/(Math.max(bb,(aa*(1+aa-bb)*0.6))),1.2));
		return((float)Math.pow(aa/(Math.max(bb,((aa-bb)*(1+(aa+bb)/2)))),1.2));
	}

	public static float charmatch(String a, String b){
		String aa=a.toLowerCase();
		String bb=b.toLowerCase();
		int ccount=0, cmatch=0;
		char cchar;
		for(int i=32; i<127; i++){
			//if a contains it then b containing it maintains the score, if b doesnt it decrements the score
			cchar=(char)i;
			//System.out.println(String.valueOf(cchar));
			if(a.contains(String.valueOf(cchar))){
				ccount++;
				if(b.contains(String.valueOf(cchar))){
					cmatch++;
				}
			}
		}
		if(ccount==0){
			if(cmatch==0){
				return 1f;
			}
			else{
				return 0f;
			}
		}
		else{
			return((float) cmatch/ccount);
		}
	}

	public static float patmatch(){
		
		//for each char in a
		//	search 
		return(0.8f);
	}

	public static float tradmatch(String a, String b){
		int tradval = a.toLowerCase().compareTo(b.toLowerCase());
		tradval = Math.abs(tradval);
		if(tradval==0){
			return 1f;
		}
		else{
			return (1f/tradval);
		}
	}

}
