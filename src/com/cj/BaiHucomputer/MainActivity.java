package com.cj.BaiHuGame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	//定义打排的大小
	private float size01=0;
	//定义变量来接收甲乙丙丁活鸟的值
	private int cjhn1=0;
	private int cjhn2=0;
	private int cjhn3=0;
	private int cjhn4=0;
	//定义变量来接收甲乙丙丁拖鸟的值
	private int cjtn1=0;
	private int cjtn2=0;
	private int cjtn3=0;
	private int cjtn4=0;
	//定义变量来接收甲乙丙丁胡息的值
	private int cjhx1=0;
	private int cjhx2=0;
	private int cjhx3=0;
	private int cjhx4=0;
	//定义甲乙丙丁的总拖鸟输赢
	int cjtn1=0;
	int cjtn2=0;
	int cjtn3=0;
	int cjtn4=0;
	
	//定义甲乙丙丁的总活鸟输赢
	float cjhn1=0;
	float cjn2=0;
	float cjn3=0;
	float cjn4=0;
	//定义甲乙丙丁的总输赢=总活鸟+总拖鸟
	float cjss1=0;
	float cjss2=0;
	float cjss3=0;
	float cjss4=0;
	//获取结果中要显示的控件的id
	private TextView cjrs1,cjrs2,cjrs3,cjrs4;
	//定义输入的控件id
	private EditText 
	size00,
	cjhntext1,
	cjhntext2,
	cjhntext3,
	cjhntext4,
	cjtntext1,
	cjtntext2,
	cjtntext3,
	cjtntext4,
	cjhxtext1,
	cjhxtext2,
	cjhxtext3,
	cjhxtext4;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cjrs1=(TextView)findViewById(R.id.cjresult1);
		cjrs2=(TextView)findViewById(R.id.cjresult2);
		cjrs3=(TextView)findViewById(R.id.cjresult3);
		cjrs4=(TextView)findViewById(R.id.cjresult4);
		size00=(EditText)findViewById(R.id.edSize);
	 cjhntext1=(EditText)findViewById(R.id.cjhn1);
	 cjhntext2=(EditText)findViewById(R.id.cjhn2);
	 cjhntext3=(EditText)findViewById(R.id.cjhn3);	
	 cjhntext4=(EditText)findViewById(R.id.cjhn4);
	 cjtntext1=(EditText)findViewById(R.id.cjtn1);
	 cjtntext2=(EditText)findViewById(R.id.cjtn2);
	 cjtntext3=(EditText)findViewById(R.id.cjtn3);
	 cjtntext4=(EditText)findViewById(R.id.cjtn4);
	 cjhxtext1=(EditText)findViewById(R.id.cjhx1);
	 cjhxtext2=(EditText)findViewById(R.id.cjhx2);
	 cjhxtext3=(EditText)findViewById(R.id.cjhx3);
	 cjhxtext4=(EditText)findViewById(R.id.cjhx4);
	}
	
	//通过点击计算来计算总输赢
	public void getResult(View view){
	//获取输赢大小
	size01= Float.parseFloat(size00.getText().toString());
	
//获取甲乙丙丁的活鸟
	cjhn1=Integer.parseInt(cjhntext1.getText().toString());	
	cjhn2=Integer.parseInt(cjhntext2.getText().toString());
	cjhn3=Integer.parseInt(cjhntext3.getText().toString());
	cjhn4=Integer.parseInt(cjhntext4.getText().toString());
	
//获取甲乙丙丁拖鸟的值
	cjtn1=Integer.parseInt(cjtntext1.getText().toString());
	cjtn2=Integer.parseInt(cjtntext2.getText().toString());
	cjtn3=Integer.parseInt(cjtntext3.getText().toString());
	cjtn4=Integer.parseInt(cjtntext4.getText().toString());
	
//获取甲乙丙丁的胡息
	cjhx1=Integer.parseInt(cjhxtext1.getText().toString());
	cjhx2=Integer.parseInt(cjhxtext2.getText().toString());
	cjhx3=Integer.parseInt(cjhxtext3.getText().toString());
	cjhx4=Integer.parseInt(cjhxtext4.getText().toString());
	
	//定义数组来接收活鸟，方便循环
	int []cjhn={cjhn1,cjhn2,cjhn3,cjhn4};
	//定义b数组来接收拖鸟的值，方便循环
	int []cjtn= {cjtn1,cjtn2,cjtn3,cjtn4};
	//定义c数组来接收胡息的值，方便循环
	int []cjhx={cjhx1,cjhx2,cjhx3,cjhx4};
	//定义甲乙丙丁总拖鸟的输赢
	int []cjstn={cjstn1,cjstn2,cjstn3,cjstn4};
	//定义甲乙丙丁总活鸟的输赢
	float []cjshn={cjshn1,cjshn2,cjshn3,cjshn4};
			
			
	//将胡息四舍五入
	for(int i=0;i<4;i++){
		if(cjhx[i]%10<5){
			cjhx[i]=cjhx[i]/10*10;
		}
		else {if(cjhx[i]<0){
			cjhx[i]=(cjhx[i]/10-1)*10;
		}else{
			cjhx[i]=(cjhx[i]/10+1)*10;
			}
		}
	}
	
	//计算甲乙丙丁依次的总活鸟值
	for(int j=0;j<4;j++){
		for(int i=0;i<4;i++){
			cjshn[j]+=(cjhx[j]-cjhx[i])*size01*(cjhn[j]+1)*(cjhn[i]+1);
		}
	}
//计算甲乙丙丁依次的总拖鸟值
	for(int j=0;j<4;j++){
		for(int i=0;i<4;i++){
			if(cjtn[j]-cjtn[i]<0){
				cjstn[j]+=-cjtn[j]-cjtn[i];
			}else if(cjtn[j]-cjtn[i]>0){
				cjstn[j]+=cjtn[j]+cjtn[i];
			}else continue;
			}
		}
	
	//甲的总输赢
	cjss1=cjshn[0]+cjstn[0];
	//乙的总输赢
		cjss2=cjshn[1]+cjstn[1];
		//丙的总输赢
		cjss3=cjshn[2]+cjstn[2];
		//丁的总输赢
		cjss4=cjshn[3]+cjstn[3];
	/*	System.out.println(cjss1);
		System.out.println(cjss2);
		System.out.println(cjss3);
		System.out.println(cjss4);*/
		cjrs1.setText(cjss1+"");
		cjrs2.setText(cjss2+"");
		cjrs3.setText(cjss3+"");
		cjrs4.setText(cjss4+"");
	}
	
	//清空所有编辑框的内容
	public void clean(View view){
		size00.setText("0");
		cjhntext1.setText("0");
		cjhntext2.setText("0");
		cjhntext3.setText("0");
		cjhntext4.setText("0");
		cjtntext1.setText("0");
		cjtntext2.setText("0");
		cjtntext3.setText("0");
		cjtntext4.setText("0");
		cjhxtext1.setText("0");
		cjhxtext2.setText("0");
		cjhxtext3.setText("0");
		cjhxtext4.setText("0");
		cjrs1.setText("0");
		cjrs2.setText("0");
		cjrs3.setText("0");
		cjrs4.setText("0");
	}
	//退出按钮的调用
	public void exit(View view){
		finish();
	}

}