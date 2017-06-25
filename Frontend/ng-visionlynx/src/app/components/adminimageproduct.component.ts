import {Component, EventEmitter, Inject, NgZone, OnInit} from "@angular/core";
import {ActivatedRoute, Route, Router} from "@angular/router";
import {NgUploaderOptions, UploadedFile} from "ngx-uploader";
import {Product} from "../classes/Product";
import {Info} from "../classes/Info";
import {ProductService} from "../services/product.service";

@Component({
    selector: 'app-adminimageproduct',
    templateUrl: '../templates/adminimageproduct.component.html'
})

export class AdminImageProductComponent implements OnInit {

    options: NgUploaderOptions;
    response: any;
    progress: number = 0;
    errorMessage: string;
    inputUploadEvents: EventEmitter<string>;
    productId;
    product:Product;

    globalInfo:Info;

    constructor(private _route:ActivatedRoute, private _productService: ProductService,
                @Inject(NgZone) private zone: NgZone, private _routeLink:Router) {
        this._route.params.subscribe(params => {
            this.productId = params['id'];
            this._productService.getProductById(this.productId).subscribe(data => {
                this.product = data;
            })
        });

        this.options = new NgUploaderOptions({
            url: '/api/image/uploadToProduct/' + this.productId,
            filterExtensions: true,
            allowedExtensions: ['jpg'],
            autoUpload: false,
            fieldName: 'file',
            method: 'POST',
            withCredentials: false,
            calculateSpeed: true
        });

        this.inputUploadEvents = new EventEmitter<string>();
    }

    ngOnInit(){
        this.globalInfo = Info;
    }

    startUpload() {
        this.inputUploadEvents.emit('startUpload');
    }

    handleUpload(data: any) {
        setTimeout(() => {
            this.zone.run(() => {
                this.response = data;
                if (data && data.response) {
                    this.response = JSON.parse(data.response);
                    setTimeout(() => {
                        this._routeLink.navigate(['/adminproducts']);
                    }, 500)
                }
                this.progress = data.progress.percent;
                console.log(data);
            });
        });
    }

}
