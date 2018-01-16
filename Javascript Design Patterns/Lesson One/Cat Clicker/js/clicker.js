
	var NUM_CATS = 5;
	var CAT_NAMES = ["Jim", "Sally", "Fluffy", "Benjamin", "Mint"];
	var IMAGE_FOLDER = "Image";
	var DEFAULT_TEXT_COLOR = "black";
	var CLICKED_COLOR = "blue"
	
	var catValues = new Array(NUM_CATS);
	var currCatIndex = 0;
	
	var catPicture = document.getElementById('catPic').addEventListener('click', function(){
		document.getElementById('counter').textContent++;
	});
	
	for (var i = 0; i < NUM_CATS; i++){
		var catListing = document.createElement('li');
		catListing.className = 'listedCats';
		catListing.id = 'listedCat' + i;
		catListing.textContent = CAT_NAMES[i];
		catValues[i] = 0;
		
		catListing.addEventListener('click', (function(index){
			return function(){
				document.getElementById('listedCat' + currCatIndex).style.color = DEFAULT_TEXT_COLOR;
				document.getElementById('listedCat' + index).style.color = CLICKED_COLOR;
				document.getElementById('catName').textContent = CAT_NAMES[index];
				document.getElementById('catPic').src = IMAGE_FOLDER + "/cat" + (index + 1) + ".jpg";
				var counter = document.getElementById('counter');
				catValues[currCatIndex] = Number(counter.textContent);
				counter.textContent = catValues[index];
				currCatIndex = index;
			};
			
		})(i));
		document.getElementById('catList').append(catListing);
	}
	
	if (NUM_CATS > 0){
		document.getElementById('listedCat0').click();
	}
