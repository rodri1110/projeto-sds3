import axios from "axios";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

function DataTable() {

    const [page, setPage] = useState<SalePage>({
        first: true,
        last: true,
        number: 0,
        totalElements: 0,
        totalPages: 0
    })

    useEffect(() => {
        axios.get(`${BASE_URL}/sales?page=0&size=20&sort=date`)
            .then(response => {
                setPage(response.data);
            })
    }, []);

    return (
        <div className="table-responsive">
            <table className="table table-striped table-sm">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Vendedor</th>
                        <th>Clientes visitados</th>
                        <th>Negócios fechados</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        page.content?.map(item => (
                            < tr key = {item.id} >
                                <th>{formatLocalDate(item.date, 'dd/MM/yyyy')}</th>
                                <th>{item.seller.name}</th>
                                <th>{item.visited}</th>
                                <th>{item.deals}</th>
                                <th>{item.amount.toFixed(2)}</th>
                            </tr>
                        ))}
                </tbody>
            </table>
        </div >
    );
}

export default DataTable;