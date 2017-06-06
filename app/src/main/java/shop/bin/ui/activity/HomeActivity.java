package shop.bin.ui.activity;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import shop.bin.R;
import shop.bin.base.SimpleActivity;
import shop.bin.model.http.response.Shop;
import shop.bin.ui.adapter.ShopAdapter;

public class HomeActivity extends SimpleActivity {


    @BindView(R.id.card_rv)
    RecyclerView recyclerView;
    ShopAdapter shopAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Shop> shops;

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initEventAndData() {

        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        shops = new ArrayList<>();
        shopAdapter = new ShopAdapter(this, shops);

        recyclerView.setAdapter(shopAdapter);

        prepareAlbums();
    }


    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

        Shop a = new Shop("Cửa hàng điện tử", "Chuyên bán đồ điện cao cấp", covers[0]);
        Shop a1 = new Shop("Cửa hàng điện tử", "Chuyên bán đồ điện cao cấp", covers[1]);
        Shop a2 = new Shop("Cửa hàng điện tử", "Chuyên bán đồ điện cao cấp", covers[2]);
        Shop a3 = new Shop("Cửa hàng điện tử", "Chuyên bán đồ điện cao cấp", covers[3]);
        Shop a4 = new Shop("Cửa hàng điện tử", "Chuyên bán đồ điện cao cấp", covers[4]);
        Shop a5 = new Shop("Cửa hàng điện tử", "Chuyên bán đồ điện cao cấp", covers[5]);
        Shop a6 = new Shop("Cửa hàng điện tử", "Chuyên bán đồ điện cao cấp", covers[6]);
        Shop a7 = new Shop("Cửa hàng điện tử", "Chuyên bán đồ điện cao cấp", covers[7]);
        Shop a8 = new Shop("Cửa hàng điện tử", "Chuyên bán đồ điện cao cấp", covers[8]);
        Shop a9 = new Shop("Cửa hàng điện tử", "Chuyên bán đồ điện cao cấp", covers[9]);
        Shop a10 = new Shop("Cửa hàng điện tử", "Chuyên bán đồ điện cao cấp", covers[10]);
        shops.add(a);
        shops.add(a1);
        shops.add(a2);
        shops.add(a3);
        shops.add(a4);
        shops.add(a5);
        shops.add(a6);
        shops.add(a7);
        shops.add(a8);
        shops.add(a9);
        shops.add(a10);

        shopAdapter.notifyDataSetChanged();
    }


    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
