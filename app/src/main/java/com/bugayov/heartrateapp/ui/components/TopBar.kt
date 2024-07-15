package com.bugayov.heartrateapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.bugayov.heartrateapp.R
import com.bugayov.heartrateapp.ui.routes.ScreenRoutes
import com.bugayov.heartrateapp.ui.theme.Red
import com.bugayov.heartrateapp.ui.theme.RubikFontFamily

@Composable
fun TopBar(
    modifier: Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = modifier
            .height(55.dp)
            .fillMaxWidth()
            .background(Red)
            .padding(9.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

@Composable
fun TopBarText(text: String) {
    Text(
        text = text,
        fontSize = 22.sp,
        fontFamily = RubikFontFamily,
        fontStyle = FontStyle.Normal,
        color = Color.White
    )
}

@Composable
fun TopBarBackButton(screenNavController: NavHostController) {
    IconButton(onClick = {
        screenNavController.navigate(ScreenRoutes.RESULT)
    }) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.White,
            modifier = Modifier
                .height(25.dp)
                .width(26.dp)
        )
    }
    Spacer(modifier = Modifier.width(30.dp))
}

@Composable
fun TopBarHistoryButton(screenNavController: NavHostController) {
    IconButton(onClick = {
        screenNavController.navigate(ScreenRoutes.HISTORY)
    }) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.history),
            contentDescription = "Back",
            tint = Color.White,
            modifier = Modifier
                .height(38.dp)
                .width(38.dp)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun TopBarPreview() {
//    TopBar(modifier = Modifier.fillMaxWidth()) {
//        TopBarBackButton({})
//        TopBarText("Gdsgsd", Modifier)
//        Spacer(Modifier.weight(1F, true))
//        TopBarHistoryButton({})
//    }
//}