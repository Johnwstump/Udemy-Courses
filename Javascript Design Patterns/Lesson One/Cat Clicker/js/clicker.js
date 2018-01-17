
	var domain = {
		CAT_NAMES : ["Jim", "Sally", "Fluffy", "Benjamin", "Mint"],
		CAT_URLS : ["http://kittentoob.com/wp-content/uploads/2018/01/A-fluffy-cat-looking-funny-surprised-or-concerned.jpg", 
		"https://img.buzzfeed.com/buzzfeed-static/static/2014-04/enhanced/webdr06/4/16/enhanced-23752-1396643152-1.jpg?downsize=715:*&output-format=auto&output-quality=auto", 
		"https://d1wn0q81ehzw6k.cloudfront.net/additional/thul/media/0eaa14d11e8930f5?w=400&h=400", 
		"https://cdn.shopify.com/s/files/1/0673/5325/files/LadyDinahs_Cat_Cafe_Alice-Block_2048x.jpg?v=1510928396",
		"https://d3n8a8pro7vhmx.cloudfront.net/taxpayers/pages/679/attachments/original/1499663166/4-ways-cheer-up-depressed-cat.jpg?1499663166"],
		cats : new Map(),
		currCat : null,
		showAdmin : false
	}
	
	
	var controller = {	
		dataChanged : false,
		
		init : function(){
			for (var i = 0; i < domain.CAT_NAMES.length; i++){
				var cat = {
					key : cat + i,
					name : domain.CAT_NAMES[i],
					counter : 0,
					url : domain.CAT_URLS[i]
				};
				domain.cats.set(cat.key, cat);
			}
			
			catView.init();
			adminView.init();
			listView.init();
			
			if (domain.currCat == null){
				this.changeCat(domain.cats.keys().next().value);
			}
		},
	    
		changeCat : function(key){
			domain.currCat = domain.cats.get(key);
			listView.render();
			catView.render();
			adminView.render();
		},
		
		updateCurrentCat : function(){
			domain.currCat.name = adminView.getAdminName();
			domain.currCat.counter = adminView.getAdminCounter();
			domain.currCat.url = adminView.getAdminUrl();
			controller.setDataChanged(true);
			listView.render();
			catView.render();
		},
		
		incrementCounter : function(){
			if (domain.currCat != null){
				domain.currCat.counter++;
				catView.render();
				adminView.render();
			}
		},
		
		showAdmin : function(){
			return domain.showAdmin;
		},
		
		toggleShowAdmin : function(){
			domain.showAdmin = !domain.showAdmin;
			adminView.render();
		},
		
		setCurrCat : function(cat){
			domain.currCat = cat;
		},
		
		getCurrCat : function(){
			return domain.currCat;
		},
		
		getCats : function(){
			return domain.cats;
		},
		
		isDataChanged : function(){
			return this.dataChanged;
		},
		
		setDataChanged : function(changed){
			this.dataChanged = changed;
		}
		
	}
	
	var listView = {
		// Constaants
		DEFAULT_TEXT_COLOR : "black",
		HIGHLIGHT_COLOR : "blue",
		// The id (cat.name) of the currently highlighted list item
		currHighlight : "",
		// The ul which contains the list items
		catList : null,
		
		init : function(){
			this.catList = document.getElementById('catList');
			this.catList.innerHTML = "";
			
			for (var cat of controller.getCats().values()){
				this.addCatToList(cat);
			}
			controller.setDataChanged(false);
		},
			
		addCatToList : function(cat){
			// Create list element for this cat
			var catListing = document.createElement('li');
			catListing.className = 'listedCats';
			catListing.id = cat.key;
			catListing.textContent = cat.name;
			
			// Create event listener to refresh views on change
			catListing.addEventListener('click', (function(key){
				return function(){
					controller.changeCat(key);
				};
			})(cat.key));
			
			// Add listing to list
			this.catList.append(catListing);
		},
		
		render : function(){
			if (controller.isDataChanged()){
				this.init();
			}
			//Highlight list element associated with currently selected cat
			this.highlight(controller.getCurrCat().key);
		},
		
		getSelected : function(){
			return this.currHighlight;
		},
		
		highlight : function(name){
			var highlight = document.getElementById(this.currHighlight);
			if (highlight != null){
				highlight.style.color = this.DEFAULT_TEXT_COLOR;
			}
			
			highlight = document.getElementById(name);
			if (highlight != null){
				highlight.style.color = this.HIGHLIGHT_COLOR;
			}
			
			this.currHighlight = name;
		}
		
	}
	
	var catView = {
		catPic : null,
		catName : null,
		counter : null,
		init : function(){
			this.catPic = document.getElementById('catPic');
			this.catName = document.getElementById('catName');
			this.counter = document.getElementById('counter');
			catPic.addEventListener('click', function(){
				controller.incrementCounter();
			});
		},
		
		render : function(){
			var cat = controller.getCurrCat();
			if (cat != null){
				this.displayCatName(cat.name);
				this.displayCatPic(cat.url);
				this.setCounterVal(cat.counter);
			}
		},
		
		displayCatName : function(name){
			catName.textContent = name;
		},
		
		displayCatPic : function(src){
			catPic.src = src;
		},
		
		getCounterVal : function(){
			return Number(counter.textContent);
		},
		
		setCounterVal : function(val){
			counter.textContent = val;
		}
	}

	var adminView = {
		adminForm : null,
		adminToggleButton : null,
		adminSubmit : null,
		changeButton: null,
		adminName : null,
		adminUrl : null,
		adminCounter : null,
		
		init : function(){
			this.adminForm = document.getElementById('adminForm');
			this.adminToggleButton = document.getElementById('adminToggleButton');
			this.adminToggleButton.addEventListener('click', function(){
				controller.toggleShowAdmin();
			});
			
			this.adminSubmit = document.getElementById('adminFormSubmit');
			this.adminName = document.getElementById('adminCatName');
			this.adminUrl = document.getElementById('adminCatImage');
			this.adminCounter = document.getElementById('adminCatCount');
			
			$('#adminForm').submit(function(ev) {
				ev.preventDefault(); 
				controller.updateCurrentCat();
			});
		},
		
		
		render : function(){
			if (controller.showAdmin()){
				var cat = controller.getCurrCat();
				this.adminName.value  = cat.name;
				this.adminUrl.value  = cat.url;
				this.adminCounter.value  = cat.counter;
				this.adminForm.style.visibility = "visible";
				this.adminSubmit.style.visibility = "visible";
			}
			else{
				this.adminForm.style.visibility = "hidden";
				this.adminSubmit.style.visibility = "hidden";
			}
			
		},
		
		getAdminCounter : function(){
			return Number(this.adminCounter.value);
		},
		
		getAdminUrl : function(){
			return String(this.adminUrl.value);
		},
		
		getAdminName : function(){
			return String(this.adminName.value);
		}
	}

	controller.init();
	