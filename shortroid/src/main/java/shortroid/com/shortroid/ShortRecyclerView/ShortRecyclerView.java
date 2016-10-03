package shortroid.com.shortroid.ShortRecyclerView;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

public class ShortRecyclerView  extends RecyclerView{

    public ShortRecyclerView(Context context) {
        super(context);
    }

    @Override
    public void setLayoutManager(LayoutManager layout) {
        super.setLayoutManager(layout);
    }

    public void setLinearLayoutManager(Context context){
        setLayoutManager(new LinearLayoutManager(context));
    }

    public void setLinearLayoutManager(Context context, int orientation, boolean reverseLayout){
        setLayoutManager(new LinearLayoutManager(context, orientation, reverseLayout));
    }

    public void setLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        setLayoutManager(new LinearLayoutManager(context, attrs, defStyleAttr, defStyleRes));
    }

    public void setGridLayoutManager(Context context, int spanCount){
        setLayoutManager(new GridLayoutManager(context, spanCount));
    }

    public void setGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout){
        setLayoutManager(new GridLayoutManager(context, spanCount, orientation, reverseLayout));
    }

    public void setGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        setLayoutManager(new GridLayoutManager(context, attrs, defStyleAttr, defStyleRes));
    }

    public void setStaggeredGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        setLayoutManager(new StaggeredGridLayoutManager(context, attrs, defStyleAttr, defStyleRes));
    }

    public void setStaggeredGridLayoutManager(int spanCount, int orientation){
        setLayoutManager(new StaggeredGridLayoutManager(spanCount, orientation));
    }

    @Override
    public void addItemDecoration(ItemDecoration decor) {
        super.addItemDecoration(decor);
    }

    public void addVerticalSpace(int height){
        addItemDecoration(new VerticalSpaceItemDecoration(height));
    }
}
