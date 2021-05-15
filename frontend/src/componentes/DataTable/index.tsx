import axios from "axios";
import Pagination from "componentes/Pagination";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

function DataTable() {
    const [activePage, setActivePage] = useState(0);
    const [page, setPage] = useState<SalePage>({
        first: true,
        last: true,
        number: 0,
        totalElements: 0,
        totalPages: 0
    })

    useEffect(() => {
        axios.get(`${BASE_URL}/sales?page=${activePage}&size=20&sort=date`)
            .then(response => {
                setPage(response.data);
            })
    }, [activePage]);

    const changePage = (index: number) => {
        setActivePage(index);
    }

    return (
        <>
            <div className ="d-flex justify-content-center">
                <Pagination page={page} onPageChange={changePage} />
            </div>
            <div className="table-responsive">
                <table className="table table-striped table-sm">
                    <thead>
                        <tr>
                            <th>Data</th>
                            <th>Player</th>
                            <th>Partidas disputadas</th>
                            <th>Vitórias</th>
                            <th>Ganho R$</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            page.content?.map(item => (
                                < tr key={item.id} >
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
        </>
    );
}

export default DataTable;