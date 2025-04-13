package com.chwltd.view.statuslayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.chwltd.utils.ImageUtils;
import com.chwltd.utils.SystemUtils;

public class SimpleStatusLayout extends LinearLayout {
    //状态布局根布局
    private RelativeLayout statusRootView;
    //加载中布局
    private LinearLayout loadingView;
    private ImageView loadingImageView;
    private TextView loadingTextView;
    private String loadingLottie = "{\"v\":\"5.5.6\",\"fr\":29.9700012207031,\"ip\":0,\"op\":102.000004154545,\"w\":1920,\"h\":1080,\"nm\":\"Comp 1\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":1,\"ty\":4,\"nm\":\"Load Outlines\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[960,540,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[1518,1004.5,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[51.515,51.515,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,-190.771],[0,0],[-192.192,0],[0,0],[0,192.192],[0,0],[0,0],[190.767,0],[0,0]],\"o\":[[0,0],[0,192.192],[0,0],[192.192,0],[0,0],[0,0],[0,-190.767],[0,0],[-190.77,0]],\"v\":[[-347.995,-338.72],[-347.995,336.15],[0,684.141],[0,684.141],[347.995,336.15],[347.995,-334.141],[347.995,-338.726],[2.58,-684.141],[-2.575,-684.141]],\"c\":true},\"ix\":2},\"nm\":\"Path 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"tm\",\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"t\":14,\"s\":[50]},{\"t\":43.0000017514259,\"s\":[0]}],\"ix\":1},\"e\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"t\":14,\"s\":[69]},{\"t\":43.0000017514259,\"s\":[19]}],\"ix\":2},\"o\":{\"a\":0,\"k\":0,\"ix\":3},\"m\":1,\"ix\":2,\"nm\":\"Trim Paths 1\",\"mn\":\"ADBE Vector Filter - Trim\",\"hd\":false},{\"ty\":\"st\",\"c\":{\"a\":0,\"k\":[0.1294,0.5882,0.9529,1],\"ix\":3},\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":0,\"k\":173.862,\"ix\":5},\"lc\":2,\"lj\":1,\"ml\":10,\"bm\":0,\"nm\":\"Stroke 1\",\"mn\":\"ADBE Vector Graphic - Stroke\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[1673.182,1042.438],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"Transform\"}],\"nm\":\"Group 1\",\"np\":3,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false},{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,233.258],[-193.632,0],[0,0],[0,-193.632],[0,0],[0,0],[190.723,0],[0,0],[0,190.724],[0,0]],\"o\":[[0,-193.632],[0,0],[193.633,0],[0,0],[0,0],[0,190.724],[0,0],[-190.724,0],[0,0],[0,-149.566]],\"v\":[[-350.603,-334.046],[-0.001,-684.641],[0,-684.641],[350.603,-334.046],[350.603,334.722],[350.603,339.305],[5.267,684.641],[-5.267,684.641],[-350.603,339.305],[-350.603,334.722]],\"c\":true},\"ix\":2},\"nm\":\"Path 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"tm\",\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"t\":0,\"s\":[81]},{\"t\":30.0000012219251,\"s\":[31]}],\"ix\":1},\"e\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"t\":0,\"s\":[100]},{\"t\":30.0000012219251,\"s\":[50]}],\"ix\":2},\"o\":{\"a\":0,\"k\":0,\"ix\":3},\"m\":1,\"ix\":2,\"nm\":\"Trim Paths 1\",\"mn\":\"ADBE Vector Filter - Trim\",\"hd\":false},{\"ty\":\"st\",\"c\":{\"a\":0,\"k\":[1,0.4,0.6,1],\"ix\":3},\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":0,\"k\":173.862,\"ix\":5},\"lc\":2,\"lj\":1,\"ml\":10,\"bm\":0,\"nm\":\"Stroke 1\",\"mn\":\"ADBE Vector Graphic - Stroke\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[1327.383,1042.938],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":-180,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"Transform\"}],\"nm\":\"Group 2\",\"np\":3,\"cix\":2,\"bm\":0,\"ix\":2,\"mn\":\"ADBE Vector Group\",\"hd\":false},{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,233.258],[-193.632,0],[0,0],[0,-193.632],[0,0],[0,0],[190.723,0],[0,0],[0,190.724],[0,0]],\"o\":[[0,-193.632],[0,0],[193.633,0],[0,0],[0,0],[0,190.724],[0,0],[-190.724,0],[0,0],[0,-149.566]],\"v\":[[-350.603,-334.046],[-0.001,-684.641],[0,-684.641],[350.603,-334.046],[350.603,334.722],[350.603,339.305],[5.267,684.641],[-5.267,684.641],[-350.603,339.305],[-350.603,334.722]],\"c\":true},\"ix\":2},\"nm\":\"Path 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"tm\",\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"t\":0,\"s\":[81]},{\"t\":30.0000012219251,\"s\":[31]}],\"ix\":1},\"e\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"t\":0,\"s\":[100]},{\"t\":30.0000012219251,\"s\":[50]}],\"ix\":2},\"o\":{\"a\":0,\"k\":0,\"ix\":3},\"m\":1,\"ix\":2,\"nm\":\"Trim Paths 1\",\"mn\":\"ADBE Vector Filter - Trim\",\"hd\":false},{\"ty\":\"st\",\"c\":{\"a\":0,\"k\":[0.3216,0.8,0.6,1],\"ix\":3},\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":0,\"k\":173.862,\"ix\":5},\"lc\":2,\"lj\":1,\"ml\":10,\"bm\":0,\"nm\":\"Stroke 1\",\"mn\":\"ADBE Vector Graphic - Stroke\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[1327.383,1042.938],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"Transform\"}],\"nm\":\"Group 4\",\"np\":3,\"cix\":2,\"bm\":0,\"ix\":4,\"mn\":\"ADBE Vector Group\",\"hd\":false},{\"ty\":\"tm\",\"s\":{\"a\":0,\"k\":0,\"ix\":1},\"e\":{\"a\":0,\"k\":100,\"ix\":2},\"o\":{\"a\":0,\"k\":0,\"ix\":3},\"m\":1,\"ix\":5,\"nm\":\"Trim Paths 1\",\"mn\":\"ADBE Vector Filter - Trim\",\"hd\":false}],\"ip\":0,\"op\":46.0000018736184,\"st\":0,\"bm\":0},{\"ddd\":0,\"ind\":2,\"ty\":4,\"nm\":\"Load2 Outlines\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[960,540,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[1518,1004.5,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[51.375,51.375,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[-192.192,0],[0,0],[0,192.192],[0,0],[190.767,0],[0,0],[0,-190.771]],\"o\":[[0,192.192],[0,0],[192.192,0],[0,0],[0,-190.768],[0,0],[-190.77,0],[0,0]],\"v\":[[-347.995,336.15],[0,684.141],[0,684.141],[347.995,336.15],[347.995,-338.725],[2.58,-684.141],[-2.575,-684.141],[-347.995,-338.72]],\"c\":true},\"ix\":2},\"nm\":\"Path 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"tm\",\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"t\":14,\"s\":[81]},{\"t\":43.0000017514259,\"s\":[31]}],\"ix\":1},\"e\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"t\":14,\"s\":[100]},{\"t\":43.0000017514259,\"s\":[50]}],\"ix\":2},\"o\":{\"a\":0,\"k\":0,\"ix\":3},\"m\":1,\"ix\":2,\"nm\":\"Trim Paths 1\",\"mn\":\"ADBE Vector Filter - Trim\",\"hd\":false},{\"ty\":\"st\",\"c\":{\"a\":0,\"k\":[1,0.502,0.4,1],\"ix\":3},\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":0,\"k\":173.862,\"ix\":5},\"lc\":2,\"lj\":1,\"ml\":10,\"bm\":0,\"nm\":\"Stroke 1\",\"mn\":\"ADBE Vector Graphic - Stroke\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[1673.182,1042.438],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"Transform\"}],\"nm\":\"Group 1\",\"np\":3,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":46.0000018736184,\"st\":0,\"bm\":0},{\"ddd\":0,\"ind\":3,\"ty\":4,\"nm\":\"Load3 Outlines\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[960,539,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[1518,1004.5,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[51.5,51.5,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,190.724],[0,233.258],[-193.633,0],[0,0],[0,-193.632],[0,0],[0,0],[190.724,0],[0,0]],\"o\":[[0,0],[0,-193.632],[0,0],[193.632,0],[0,0],[0,0],[0,190.724],[0,0],[-190.724,0]],\"v\":[[-350.603,339.305],[-350.603,-334.046],[0,-684.641],[0.001,-684.641],[350.603,-334.046],[350.603,334.722],[350.603,339.305],[5.267,684.641],[-5.267,684.641]],\"c\":true},\"ix\":2},\"nm\":\"Path 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"tm\",\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"t\":52,\"s\":[50]},{\"t\":82.0000033399285,\"s\":[0]}],\"ix\":1},\"e\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"t\":52,\"s\":[69]},{\"t\":82.0000033399285,\"s\":[19]}],\"ix\":2},\"o\":{\"a\":0,\"k\":0,\"ix\":3},\"m\":1,\"ix\":2,\"nm\":\"Trim Paths 1\",\"mn\":\"ADBE Vector Filter - Trim\",\"hd\":false},{\"ty\":\"st\",\"c\":{\"a\":0,\"k\":[0.3216,0.8,0.6,1],\"ix\":3},\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":0,\"k\":173.862,\"ix\":5},\"lc\":2,\"lj\":1,\"ml\":10,\"bm\":0,\"nm\":\"Stroke 1\",\"mn\":\"ADBE Vector Graphic - Stroke\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[1327.382,1042.938],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"Transform\"}],\"nm\":\"Group 4\",\"np\":3,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":45.0000018328876,\"op\":103.000004195276,\"st\":7.00000028511585,\"bm\":0},{\"ddd\":0,\"ind\":4,\"ty\":4,\"nm\":\"Load3 Outlines\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":180,\"ix\":10},\"p\":{\"a\":0,\"k\":[764,580,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[1518,1004.5,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[51.5,51.5,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,190.724],[0,233.258],[-193.633,0],[0,0],[0,-193.632],[0,0],[0,0],[190.724,0],[0,0]],\"o\":[[0,0],[0,-193.632],[0,0],[193.632,0],[0,0],[0,0],[0,190.724],[0,0],[-190.724,0]],\"v\":[[-350.603,339.305],[-350.603,-334.046],[0,-684.641],[0.001,-684.641],[350.603,-334.046],[350.603,334.722],[350.603,339.305],[5.267,684.641],[-5.267,684.641]],\"c\":true},\"ix\":2},\"nm\":\"Path 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"st\",\"c\":{\"a\":0,\"k\":[1,0.4,0.6,1],\"ix\":3},\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":0,\"k\":173.862,\"ix\":5},\"lc\":2,\"lj\":1,\"ml\":10,\"bm\":0,\"nm\":\"Stroke 1\",\"mn\":\"ADBE Vector Graphic - Stroke\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[1327.382,1042.938],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"Transform\"}],\"nm\":\"Group 2\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false},{\"ty\":\"tm\",\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"t\":52,\"s\":[50]},{\"t\":82.0000033399285,\"s\":[0]}],\"ix\":1},\"e\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"t\":52,\"s\":[69]},{\"t\":82.0000033399285,\"s\":[19]}],\"ix\":2},\"o\":{\"a\":0,\"k\":0,\"ix\":3},\"m\":1,\"ix\":2,\"nm\":\"Trim Paths 1\",\"mn\":\"ADBE Vector Filter - Trim\",\"hd\":false}],\"ip\":45.0000018328876,\"op\":103.000004195276,\"st\":-3.00000012219251,\"bm\":0},{\"ddd\":0,\"ind\":5,\"ty\":4,\"nm\":\"Load3 Outlines\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[960,540,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[1518,1004.5,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[51.5,51.5,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[-192.192,0],[0,0],[0,192.192],[0,0],[0,0],[190.767,0],[0,0],[0,-190.771]],\"o\":[[0,192.192],[0,0],[192.192,0],[0,0],[0,0],[0,-190.768],[0,0],[-190.77,0],[0,0]],\"v\":[[-347.995,336.15],[0,684.141],[0,684.141],[347.995,336.15],[347.995,-334.141],[347.995,-338.725],[2.58,-684.141],[-2.575,-684.141],[-347.995,-338.72]],\"c\":true},\"ix\":2},\"nm\":\"Path 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"tm\",\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"t\":66,\"s\":[81]},{\"t\":96.0000039101602,\"s\":[31]}],\"ix\":1},\"e\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"t\":66,\"s\":[100]},{\"t\":96.0000039101602,\"s\":[50]}],\"ix\":2},\"o\":{\"a\":0,\"k\":0,\"ix\":3},\"m\":1,\"ix\":2,\"nm\":\"Trim Paths 1\",\"mn\":\"ADBE Vector Filter - Trim\",\"hd\":false},{\"ty\":\"st\",\"c\":{\"a\":0,\"k\":[0.1294,0.5882,0.9529,1],\"ix\":3},\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":0,\"k\":173.862,\"ix\":5},\"lc\":2,\"lj\":1,\"ml\":10,\"bm\":0,\"nm\":\"Stroke 1\",\"mn\":\"ADBE Vector Graphic - Stroke\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[1673.182,1042.438],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"Transform\"}],\"nm\":\"Group 1\",\"np\":3,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":45.0000018328876,\"op\":103.000004195276,\"st\":3.00000012219251,\"bm\":0},{\"ddd\":0,\"ind\":6,\"ty\":4,\"nm\":\"Load3 Outlines\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":-180,\"ix\":10},\"p\":{\"a\":0,\"k\":[1120,570,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[1518,1004.5,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[51.5,51.5,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[-192.192,0],[0,0],[0,192.192],[0,0],[0,0],[190.767,0],[0,0],[0,-190.771]],\"o\":[[0,192.192],[0,0],[192.192,0],[0,0],[0,0],[0,-190.768],[0,0],[-190.77,0],[0,0]],\"v\":[[-347.995,336.15],[0,684.141],[0,684.141],[347.995,336.15],[347.995,-334.141],[347.995,-338.725],[2.58,-684.141],[-2.575,-684.141],[-347.995,-338.72]],\"c\":true},\"ix\":2},\"nm\":\"Path 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"tm\",\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"t\":66,\"s\":[81]},{\"t\":96.0000039101602,\"s\":[31]}],\"ix\":1},\"e\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"t\":66,\"s\":[100]},{\"t\":96.0000039101602,\"s\":[50]}],\"ix\":2},\"o\":{\"a\":0,\"k\":0,\"ix\":3},\"m\":1,\"ix\":2,\"nm\":\"Trim Paths 1\",\"mn\":\"ADBE Vector Filter - Trim\",\"hd\":false},{\"ty\":\"st\",\"c\":{\"a\":0,\"k\":[1,0.502,0.4,1],\"ix\":3},\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":0,\"k\":173.862,\"ix\":5},\"lc\":2,\"lj\":1,\"ml\":10,\"bm\":0,\"nm\":\"Stroke 1\",\"mn\":\"ADBE Vector Graphic - Stroke\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[1673.182,1022.438],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"Transform\"}],\"nm\":\"Group 3\",\"np\":3,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":45.0000018328876,\"op\":103.000004195276,\"st\":3.00000012219251,\"bm\":0}],\"markers\":[]}";
    //空布局
    private LinearLayout emptyView;
    private ImageView emptyImageView;
    private TextView emptyTextView;
    //错误布局
    private LinearLayout errorView;
    private ImageView errorImageView;
    private TextView errorTextView;
    //网络错误布局
    private LinearLayout networkErrorView;
    private ImageView networkErrorImageView;
    private TextView networkErrorTextView;
    //无权限布局
    private LinearLayout noPermissionView;
    private ImageView noPermissionImageView;
    private TextView noPermissionTextView;
    //无数据布局
    private LinearLayout noDataView;
    private ImageView noDataImageView;
    private TextView noDataTextView;
    //自定义布局
    private LinearLayout customView;
    //当前显示的布局
    private LinearLayout currentView;
    //屏幕数据
    private int screenWidth;
    private int screenHeight;

    public SimpleStatusLayout(Context context) {
        super(context);
        init();
    }

    public SimpleStatusLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SimpleStatusLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public SimpleStatusLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //获取屏幕数据
        screenWidth = SystemUtils.getScreenWidth(getContext());
        screenHeight = SystemUtils.getScreenHeight(getContext());
        //初始化布局
        statusRootView = new RelativeLayout(getContext());
        loadingView = new LinearLayout(getContext());
        emptyView = new LinearLayout(getContext());
        errorView = new LinearLayout(getContext());
        networkErrorView = new LinearLayout(getContext());
        noPermissionView = new LinearLayout(getContext());
        noDataView = new LinearLayout(getContext());
        customView = new LinearLayout(getContext());
        //设置布局参数
        statusRootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        loadingView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        emptyView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        errorView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        networkErrorView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        noPermissionView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        noDataView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        customView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        //设置布局可视度
        statusRootView.setVisibility(GONE);
        loadingView.setVisibility(GONE);
        emptyView.setVisibility(GONE);
        errorView.setVisibility(GONE);
        networkErrorView.setVisibility(GONE);
        noPermissionView.setVisibility(GONE);
        noDataView.setVisibility(GONE);
        customView.setVisibility(GONE);
        //添加布局
        statusRootView.addView(loadingView);
        statusRootView.addView(emptyView);
        statusRootView.addView(errorView);
        statusRootView.addView(networkErrorView);
        statusRootView.addView(noPermissionView);
        statusRootView.addView(noDataView);
        statusRootView.addView(customView);
        addView(statusRootView);
        //初始化加载中布局
        initLoadingView();
    }

    //初始化加载中布局
    private void initLoadingView() {
        loadingView.setOrientation(VERTICAL);
        loadingView.setGravity(Gravity.CENTER);
        //初始化布局
        loadingImageView = new ImageView(getContext());
        loadingTextView = new TextView(getContext());
        loadingView.addView(loadingImageView);
        loadingView.addView(loadingTextView);
        //设置布局参数
        loadingImageView.setLayoutParams(new LayoutParams(screenWidth/3, screenHeight/3));
        loadingTextView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        //加载动画
        ImageUtils.playLottie(loadingImageView,loadingLottie);
    }

    public void showLoading(boolean status) {
        if(currentView != null) {
            currentView.setVisibility(GONE);
        }
        if(status) {
            loadingView.setOnClickListener(view -> {
                hide();
            });
        }
        loadingView.setVisibility(VISIBLE);
        currentView = loadingView;
        showView(statusRootView);
    }

    public void hide() {
        hideView(statusRootView);
    }

    private void hideView(ViewGroup view) {
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration(500);
        TransitionManager.beginDelayedTransition(view, autoTransition);
        statusRootView.setVisibility(GONE);
    }

    private void showView(ViewGroup view) {
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration(500);
        TransitionManager.beginDelayedTransition(view, autoTransition);
        view.setVisibility(VISIBLE);
    }
}
