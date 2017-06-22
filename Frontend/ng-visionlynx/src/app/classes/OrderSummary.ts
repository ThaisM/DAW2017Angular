import {OrderCart} from "./OrderCart";

export class OrderSummary{
    id: string;
    ordername: string;
    user: string;
    paymentmethod: string;
    state: string;
    totalprice: number;
    order: OrderCart[];
}
