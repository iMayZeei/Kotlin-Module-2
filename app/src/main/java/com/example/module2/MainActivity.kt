package com.example.module2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.module2.ui.theme.Module2Theme
import androidx.compose.foundation.layout.Spacer
import android.widget.Toast
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.platform.LocalContext
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ShoppingCartScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Hello(name: String?, modifier: Modifier = Modifier) {
    Text(
        text = if (name == null) "Имя не задано" else "Привет, $name!",
        modifier = modifier
    )
}

@Preview(
    name = "Portrait",
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp,orientation=portrait"
)
@Preview(
    name = "Landscape",
    showSystemUi = true,
    device = "spec:width=891dp,height=411dp,orientation=landscape"
)
@Composable
fun HelloPreview() {
    Module2Theme {
        Hello("Матвей", modifier = Modifier.padding(top = 32.dp))
    }
}

@Preview(
    name = "Round",
    showSystemUi = true,
    device = "spec:width=200dp,height=200dp,dpi=320,isRound=true"
)
@Composable
fun HelloRoundPreview() {
    Module2Theme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Hello("Матвей")
        }
    }
}

@Preview(showBackground = true, name = "Task 3")
@Composable
fun Task3Preview() {
    val text = stringResource(R.string.compose_description)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = text,
            color = Color.Green,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = text,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = text,
            fontSize = 24.sp,
            color = Color.Black,
            textDecoration = TextDecoration.Underline,
            style = TextStyle(
                textIndent = TextIndent(firstLine = 48.sp)
            ),
            modifier = Modifier.background(Color.Green)
        )
    }
}

@Preview(
    name = "Portrait",
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=360dp,height=720dp,dpi=420"
)
@Composable
fun Task4Preview() {
    Module2Theme {
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(2.dp, Color.Gray),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 4.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Black
            )
        ) {
            Text("Нажми на меня")
        }
    }
}

@Preview(
    name = "Portrait - Task5",
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=360dp,height=720dp,dpi=420"
)
@Composable
fun Task5Preview() {
    Module2Theme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
                .height(100.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 16.dp)
                    .aspectRatio(1f)
                    .background(
                        Color(0xFFFF5722),
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "КМ",
                    color = Color.Black
                )
            }
        }
    }
}

@Preview(
    name = "Portrait - Task6.1",
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=360dp,height=720dp,dpi=420"
)
@Composable
fun Task6FirstPreview() {
    Module2Theme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(top = 32.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(width = 240.dp, height = 120.dp)
                    .background(Color.Black)
            ) {
                Image(
                    painter = painterResource(R.drawable.circle),
                    contentDescription = "Оранжевый круг",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(48.dp)
                )
            }
        }
    }
}

@Preview(
    name = "Portrait - Task6.2",
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=360dp,height=720dp,dpi=420"
)
@Composable
fun Task6SecondPreview() {
    Module2Theme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(top = 32.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(width = 240.dp, height = 120.dp)
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.circle),
                    contentDescription = "Фиолетовый круг",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds,
                    colorFilter = ColorFilter.tint(Color(0xFF800080))
                )
            }
        }
    }
}

@Preview(
    name = "Portrait - Task7.1",
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=360dp,height=720dp,dpi=420"
)
@Composable
fun Task7FirstPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 32.dp)
    ) {
        Text("Имя: Евгений")
        Text("Отчество: Андреевич")
        Text("Фамилия: Лукашин")
        Text("Мобильный телефон: +7 495 495 95 95")
        Text("Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12")
    }
}

@Preview(
    name = "Portrait - Task7.2",
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=360dp,height=720dp,dpi=420"
)
@Composable
fun Task7SecondPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 32.dp)
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Имя: Евгений\n" +
                    "Отчество: Андреевич\n" +
                    "Фамилия: Лукашин\n" +
                    "Мобильный телефон: +7 495 495 95 95\n" +
                    "Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(8.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Имя: Василий\n" +
                    "Отчество: Егорович\n" +
                    "Фамилия: Кузякин\n" +
                    "Мобильный телефон: ---\n" +
                    "Адрес: Ивановская область, дер. Крутово, д. 4",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(8.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Имя: Людмила\n" +
                    "Отчество: Прокофьевна\n" +
                    "Фамилия: Калугина\n" +
                    "Мобильный телефон: +7 495 788 78 78\n" +
                    "Адрес: Москва, Большая Никитская, д. 43, кв. 290",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(8.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(
    name = "Portrait - Task7.3",
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=360dp,height=720dp,dpi=420"
)
@Composable
fun Task7ThirdPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 32.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Имя: Евгений", fontSize = 12.sp)
                Text("Отчество: Андреевич", fontSize = 12.sp)
                Text("Фамилия: Лукашин", fontSize = 12.sp)
                Text(
                    "Мобильный телефон: +7 495 495 95 95",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    "Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }

            Image(
                painter = painterResource(R.drawable.circle),
                contentDescription = "Изображение контакта",
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Composable
fun WaterTracker(modifier: Modifier = Modifier) {
    var waterCount by rememberSaveable { mutableStateOf(100) }
    var streakDays by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF405A85)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "$waterCount мл",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF405A85)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                waterCount += 250
            }
        ) {
            Text("+250 мл")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Дней подряд (1500 мл и более): $streakDays",
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (waterCount >= 1500) {
                    streakDays++
                } else {
                    streakDays = 0
                }

                waterCount = 0
            }
        ) {
            Text("Завершить день")
        }
    }
}

@Preview(
    name = "Portrait - Task8",
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=360dp,height=720dp,dpi=420"
)
@Composable
fun Task8Preview() {
    Module2Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            WaterTracker(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}


data class Cart(
    val products: List<Product>
)

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

@Composable
fun ShoppingCartScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    var cart by remember {
        mutableStateOf(
            Cart(
                listOf(
                    Product(0, "Товар #1", 100),
                    Product(1, "Товар #2", 150),
                    Product(2, "Товар #3", 56)
                )
            )
        )
    }

    var nextProductId by remember {
        mutableIntStateOf(3)
    }

    val totalSum = cart.products.sumOf { it.price }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        for (product in cart.products) {
            Text(
                text = "${product.name} - ${product.price} рублей"
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Товаров на сумму: $totalSum рублей"
        )

        AddProductSection {
            val newProduct = Product(
                id = nextProductId,
                name = "Товар #${nextProductId + 1}",
                price = Random.nextInt(0, 100)
            )

            nextProductId++

            cart = cart.copy(
                products = cart.products + newProduct
            )

            if (cart.products.sumOf { it.price } > 500) {
                Toast.makeText(
                    context,
                    "Доставка бесплатная!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        if (cart.products.isNotEmpty()) {
            RemoveProductSection {
                cart = cart.copy(
                    products = cart.products.dropLast(1)
                )
            }
        }
    }
}

@Composable
fun AddProductSection(onAdd: () -> Unit) {
    Button(onClick = onAdd) {
        Text("Добавить товар")
    }
}

@Composable
fun RemoveProductSection(onRemove: () -> Unit) {
    Button(onClick = onRemove) {
        Text("Удалить товар")
    }
}

@Preview(
    name = "Portrait - Task10",
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=360dp,height=720dp,dpi=420"
)
@Composable
fun Task10Preview() {
    Module2Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ShoppingCartScreen(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}