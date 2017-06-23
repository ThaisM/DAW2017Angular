export class Product{
    id: number;
    name: string;
    brand: string;
    model: string;
    reference: string;
    type: string;
    subtype: string;
    size: string;
    sphere: string;
    radio: string;
    published: boolean;
    price: number;
    quantity: number;
    image: string;
    description: string;
    offer: boolean;

    public static compare(product1: Product, product2: Product):number{
        if(product1.price > product2.price){
            return 1;
        }
        if(product1.price < product2.price){
            return -1;
        }
        return 0;
    }
}
