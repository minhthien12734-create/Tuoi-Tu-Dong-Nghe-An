package vn.aquara.app;

import android.app.*;
import android.os.Bundle;
import android.content.*;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {
    final int GREEN = Color.rgb(19,128,75), DARK = Color.rgb(24,35,30);
    LinearLayout page;
    VideoView video;
    int dp(float n){return (int)(n*getResources().getDisplayMetrics().density+0.5f);}
    GradientDrawable bg(int color,int radius){GradientDrawable d=new GradientDrawable();d.setColor(color);d.setCornerRadius(dp(radius));return d;}
    TextView text(String s,int size,int color,boolean bold){TextView t=new TextView(this);t.setText(s);t.setTextSize(size);t.setTextColor(color);if(bold)t.setTypeface(null,Typeface.BOLD);return t;}
    void pad(View v,int a,int b,int c,int d){v.setPadding(dp(a),dp(b),dp(c),dp(d));}
    @Override public void onCreate(Bundle b){super.onCreate(b);getWindow().setStatusBarColor(GREEN);getWindow().setNavigationBarColor(Color.BLACK);build();}
    void build(){
        ScrollView scroll=new ScrollView(this);scroll.setFillViewport(true);scroll.setBackgroundColor(Color.WHITE);
        page=new LinearLayout(this);page.setOrientation(LinearLayout.VERTICAL);pad(page,12,12,12,22);scroll.addView(page);setContentView(scroll);
        LinearLayout brand=new LinearLayout(this);brand.setGravity(Gravity.CENTER_VERTICAL);page.addView(brand);
        ImageView logo=new ImageView(this);logo.setImageResource(vn.aquara.app.R.drawable.ic_launcher);brand.addView(logo,new LinearLayout.LayoutParams(dp(44),dp(44)));
        LinearLayout names=new LinearLayout(this);names.setOrientation(1);pad(names,9,0,0,0);brand.addView(names);
        names.addView(text("TƯỚI TỰ ĐỘNG NGHỆ AN",17,DARK,true));names.addView(text("TƯỚI TỰ ĐỘNG · ĐIỆN THÔNG MINH",9,GREEN,true));
        gap(14);
       ImageView banner = new ImageView(this);
banner.setImageResource(R.drawable.anh_gioi_thieu);
banner.setScaleType(ImageView.ScaleType.CENTER_CROP);
banner.setBackground(bg(Color.rgb(225,238,229),15));
banner.setClipToOutline(true);
page.addView(banner,
    new LinearLayout.LayoutParams(-1,dp(235)));gap(5);
        page.addView(text("Tiết kiệm nước · Chăm sóc cảnh quan · Tự động hóa ngôi nhà",12,Color.DKGRAY,false));gap(13);
        Button call=new Button(this);call.setText("☎  GỌI NGAY · 0911113759");call.setTextColor(Color.WHITE);call.setTextSize(15);call.setAllCaps(false);call.setBackground(bg(GREEN,10));page.addView(call,new LinearLayout.LayoutParams(-1,dp(54)));
        call.setOnClickListener(v->{Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:0911113759"));startActivity(i);});
        gap(18);page.addView(text("DỊCH VỤ CỦA CHÚNG TÔI",13,GREEN,true));gap(9);
        LinearLayout cards=new LinearLayout(this);cards.setOrientation(LinearLayout.HORIZONTAL);page.addView(cards);
        addCard(cards,"♧","Tưới tự động","Tưới cỏ, nhỏ giọt, phun mưa",true);
        addCard(cards,"⌂","Điện thông minh","Chiếu sáng, an ninh, tự động hóa",false);
        gap(22);
        TextView foot=text("TƯỚI TỰ ĐỘNG NGHỆ AN · HÀ TĨNH\nTư vấn và lắp đặt: 0911113759",12,Color.GRAY,false);foot.setGravity(Gravity.CENTER);page.addView(foot);
        gap(10);TextView privacy=text("Chính sách quyền riêng tư",12,GREEN,false);privacy.setGravity(Gravity.CENTER);page.addView(privacy);
        privacy.setOnClickListener(v->showPrivacy());
    }
    void gap(int h){Space s=new Space(this);page.addView(s,new LinearLayout.LayoutParams(1,dp(h)));}
    void addCard(LinearLayout row,String symbol,String title,String desc,boolean left){
        LinearLayout card=new LinearLayout(this);card.setOrientation(1);pad(card,11,12,11,13);card.setBackground(bg(left?Color.rgb(236,246,240):Color.rgb(242,245,242),12));
        LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(0,dp(142),1);if(left)p.rightMargin=dp(8);row.addView(card,p);
        card.addView(text(symbol,24,GREEN,true));card.addView(text(title,15,DARK,true));gapInside(card,5);card.addView(text(desc,11,Color.DKGRAY,false));
        card.setOnClickListener(v->showService(left));
    }
    void gapInside(LinearLayout l,int h){l.addView(new Space(this),new LinearLayout.LayoutParams(1,dp(h)));}
    void showService(boolean irrigation){
        String title=irrigation?"TƯỚI TỰ ĐỘNG":"ĐIỆN THÔNG MINH";
        String msg=irrigation?"• Tưới cỏ sân vườn, béc tưới phun mưa\n• Tưới nhỏ giọt, tưới gốc cây\n• Hẹn giờ và điều khiển bằng điện thoại\n• Thiết kế, lắp đặt, bảo trì tại Nghệ An – Hà Tĩnh":"• Công tắc và chiếu sáng thông minh\n• Điều khiển thiết bị bằng điện thoại\n• Tự động hóa ngôi nhà\n• Giải pháp an ninh và tư vấn lắp đặt";
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setNegativeButton("Đóng",null).setPositiveButton("GỌI NGAY",(d,w)->startActivity(new Intent(Intent.ACTION_DIAL,Uri.parse("tel:0911113759")))).show();
    }
    void showPrivacy(){new AlertDialog.Builder(this).setTitle("Quyền riêng tư").setMessage("Phiên bản này không yêu cầu đăng nhập, không thu thập thông tin cá nhân và không gửi dữ liệu lên máy chủ. Nút GỌI NGAY chỉ mở trình quay số của điện thoại. Video được lưu trong ứng dụng.").setPositiveButton("Đã hiểu",null).show();}
    @Override protected void onPause(){super.onPause();if(video!=null && video.isPlaying())video.pause();}
}
