package pe.edu.ulima.pichangers.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by alex on 5/16/16.
 */
public class ListaEquiposItem extends ImageView {

    public ListaEquiposItem(Context context) {
        super(context);
    }

    public ListaEquiposItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListaEquiposItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
