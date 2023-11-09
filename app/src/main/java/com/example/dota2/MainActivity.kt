package com.example.dota2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dota2.R
import com.example.dota2.ui.theme.DoTA2Theme

class DotaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoTA2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val tagsList : List<String> = listOf("MOBA", "MULTIPLAYER", "STRATEGY")
                    DotaScreen(tagsList)
                }
            }
        }
    }
}

@Composable
fun DotaScreen(tagsList: List<String>){
    Box {
        HeaderImage()
        MainContent()
        GameInfo()
        Icon()
    }
    LazyColumn(
        modifier = Modifier
            .padding(top = 392.dp, start = 24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ){
        item {
            GameTags(tagsList)
        }
        item {
            Description()
        }
        item {
            ImageScrollBar()
        }
        item {
            Raitings()
        }
        item {
            ReviewBar()
        }
    }
    InstallButton()

}

@Composable
fun HeaderImage(){
    Box(
        modifier = Modifier.fillMaxWidth(),
    ){
        Image(painter = painterResource(id = R.drawable.header),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop)
    }
}
@Preview(showBackground = true)
@Composable
fun Icon(){
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(21.dp, 281.dp)
            .size(88.dp)
            .border(2.dp, Color(31, 36, 48), RoundedCornerShape(15.dp))
            .clip(RoundedCornerShape(15.dp))
            .background(color = Color.Black)
    ) {
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.size(67.dp))

    }
}

@Composable
fun GameInfo(){
    Box(
        modifier = Modifier
            .padding(top = 324.dp, start = 124.dp)
    ){
        Text(
            text = "DoTA 2",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 26.sp,
                fontFamily = FontFamily(Font(R.font.sk_modernist)),
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),
                letterSpacing = 0.5.sp,
            )
        )
        Image(
            modifier = Modifier
                .padding(0.dp, 32.dp)
                .size(76.dp, 12.dp),
            painter = painterResource(id = R.drawable.stars),
            contentDescription = null
        )
        Text(modifier = Modifier
            .padding(86.dp, 32.dp)
            .size(76.dp, 12.dp),
            text = "70M",
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.sk_modernist)),
                fontWeight = FontWeight(400),
                color = Color(0xFF45454D),

                letterSpacing = 0.5.sp,
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainContent(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 312.dp)
            .background(
                color = Color(0xFF050B18),
                shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)
            )
    ) {
    }
}

@Preview
@Composable
fun Description(){
    Box(
        modifier = Modifier
            .size(327.dp, 80.dp)
    ){
        Text(
            text = stringResource(id = R.string.description),
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                fontFamily = FontFamily(Font(R.font.sk_modernist)),
                fontWeight = FontWeight(400),
                color = Color(0xB2EEF2FB),
            )
        )
    }
}

@Preview
@Composable
fun ImageScrollBar(){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .height(135.dp)
    ){
        item{
            Image( modifier = Modifier
                .clip(shape = RoundedCornerShape(12.dp)),
                painter = painterResource(id = R.drawable.scroller_img1),
                contentDescription = null)
        }
        item{
            Image( modifier = Modifier
                .clip(shape = RoundedCornerShape(12.dp)),
                painter = painterResource(id = R.drawable.scroller_img2),
                contentDescription = null)
        }
    }
}
@Composable
fun GameTags(list: List<String>){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ){
        items(list) { item ->
            Box(
                modifier = Modifier
                    .height(22.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color(0x3D44A9F4),
                        shape = RoundedCornerShape(size = 100.dp)
                    )
            ){
                Text(modifier = Modifier
                    .padding(10.dp, 4.dp),
                    text =  item,
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF44A9F4),

                        )
                )
            }
        }
    }
}

@Composable
fun Raitings(){
    Box(
        modifier = Modifier
            .size(300.dp, 150.dp),
    ){
        Text(
            text = "Review & Ratings",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.sk_modernist)),
                fontWeight = FontWeight(700),
                color = Color(0xFFEEF2FB),

                letterSpacing = 0.6.sp,
            )
        )
        Text(
            modifier = Modifier
                .padding(0.dp, 31.dp),
            text = "4.9",
            style = TextStyle(
                fontSize = 48.sp,
                fontFamily = FontFamily(Font(R.font.sk_modernist)),
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),

                )
        )
        Box(
            modifier = Modifier
                .padding(77.dp, 48.dp)
        ){
            Text(
                modifier = Modifier
                    .padding(0.dp, 20.dp),
                text = "70M Reviews",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.sk_modernist)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFA8ADB7),
                    letterSpacing = 0.5.sp,
                )
            )
            Image(
                modifier = Modifier
                    .size(76.dp, 12.dp),
                painter = painterResource(id = R.drawable.bottom_rating),
                contentDescription = null)
        }

    }
}

@Preview
@Composable
fun ReviewBar(){
    Column {
        Box() {
            Image(
                modifier = Modifier.size(36.dp),
                painter = painterResource(id = R.drawable.user1),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(52.dp, 0.dp),
                text = "Auguste Conte",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.sk_modernist)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                    letterSpacing = 0.5.sp,
                )
            )
            Text(
                modifier = Modifier.padding(52.dp, 24.dp),
                text = "February 14, 2019",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.sk_modernist)),
                    fontWeight = FontWeight(400),
                    color = Color(0x66FFFFFF),
                    letterSpacing = 0.5.sp,
                )
            )
            Text(
                modifier = Modifier.padding(0.dp, 62.dp),
                text = "“Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers.”",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(Font(R.font.sk_modernist)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFA8ADB7),
                    letterSpacing = 0.5.sp,
                )
            )
        }
        Image(
            modifier = Modifier.size(300.dp, 2.dp),
            painter = painterResource(id = R.drawable.borderline),
            contentDescription = null)

        Box {
            Image(
                modifier = Modifier.size(36.dp),
                painter = painterResource(id = R.drawable.user2),
                contentDescription = null
            )
            Text(modifier = Modifier.padding(52.dp, 0.dp),
                text = "Jang Marcelino",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.sk_modernist)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                    letterSpacing = 0.5.sp,
                )
            )

            Text(modifier = Modifier.padding(52.dp, 24.dp),
                text = "February 14, 2019",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.sk_modernist)),
                    fontWeight = FontWeight(400),
                    color = Color(0x66FFFFFF),
                    letterSpacing = 0.5.sp,
                )
            )
            Text(modifier = Modifier.padding(0.dp, 62.dp),
                text = "“Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers.”",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(Font(R.font.sk_modernist)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFA8ADB7),
                    letterSpacing = 0.5.sp,
                )
            )
        }
        Box(modifier = Modifier
            .size(105.dp))
    }
}


@Preview
@Composable
fun InstallButton(){
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 650.dp, bottom = 38.dp)
            .size(345.dp, 64.dp)
            .clickable {

            }
            .background(
                color = Color(0xFFF4D144), shape = RoundedCornerShape(size = 12.dp)

            )

    ){

        Text(modifier = Modifier
            .padding(134.dp, 20.dp),
            text = "Install",
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.sk_modernist)),
                fontWeight = FontWeight(700),
                color = Color(0xFF050B18),

                letterSpacing = 0.6.sp,
            )
        )
    }
}